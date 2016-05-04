package com.yourcompany;


import com.yourcompany.models.SauceSubUserList;
import com.yourcompany.models.SauceUser;
import com.yourcompany.models.UsageList;
import com.yourcompany.models.UsersToDelete;
import com.yourcompany.service.SauceLabsService;
import com.yourcompany.service.SauceLabsServiceGenerator;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mehmetgerceker on 4/7/16.
 */
public class SauceRestExample {

    public static void main(String[] args) throws InterruptedException {
        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");

        SauceLabsService service =
                SauceLabsServiceGenerator.createService(SauceLabsService.class, username, accessKey);

        //System.out.println("Flat Sub-Account List");
        //System.out.println("============================");
        //printSubAccounts(service, username);
        //System.out.println("============================");
        //System.out.println("Hierarchical Sub-Ac" +
        //        "count Tree");
        //System.out.println("============================");
        //printUserTree(service, username);
        //System.out.println("============================");

        //getIdleSubAccounts(39, username, service);
        deleteIdleSubAccounts(30, username, service);
    }


    private static void printSubAccounts(SauceLabsService service, String parentUsername){
        List<SauceUser> subUsers = getSubAccounts(service, parentUsername);

        for(SauceUser user:subUsers){
            System.out.format("Username: %s, Email: %s\n", user.getUsername(), user.getEmail());
        }
    }

    private static List<SauceUser> getSubAccounts(SauceLabsService service, String parentUsername){
        List<SauceUser> subUsers = null;
        try{
            Call<List<SauceUser>> subAccountCall = service.getSubAccounts(parentUsername);
            subUsers = subAccountCall.execute().body();

        } catch (IOException e){
            e.printStackTrace();
        }
        return subUsers;
    }

    private static void printUserTree(SauceLabsService service, String username, boolean withTunnels) {
        try{
            Call<SauceUser> mainUserCall = service.getUser(username);
            SauceUser user = mainUserCall.execute().body();
            System.out.format("First Name: %s, Last Name: %s, Username: %s, Email: %s\n",
                    user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail());
            if (withTunnels) {
                List<String> tunnelIds = getUserTunnelIds(service, username);
                //tunnelIds = tunnelIds ? tunnelIds != null : new ArrayList<>();
                System.out.format("Tunnels: %s\n", tunnelIds.stream().collect(Collectors.joining(",")));
            }
            printUserTree(service, username, "", withTunnels);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void printUserTree(SauceLabsService service, String username, String levelPad, boolean withTunnels)
            throws IOException{
        Call<SauceSubUserList> subAccountsCall = service.getSubAccountsList(username);
        List<SauceUser> subUsers = subAccountsCall.execute().body().getSubUsers();
        for(SauceUser user:subUsers){
            String childPad = levelPad+"\t";
            System.out.format("%s-First Name: %s, Last Name: %s, Username: %s, Email: %s\n",
                    childPad, user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail());
            if (withTunnels) {
                System.out.format("%s-Tunnels: %s\n",
                        childPad, getUserTunnelIds(service, username).stream().collect(Collectors.joining(",")));
            }
            printUserTree(service, user.getUsername(), childPad, withTunnels);
        }
    }

    private static boolean accountUsedInTheLast(int days, String username, SauceLabsService service){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -days);
        Date cutoffDate = cal.getTime();
        System.out.format("Cutoff date is %s.\n", cutoffDate.toString());
        try {
            Call<UsageList> mainUserCall = service.getUserUsage(username);
            UsageList usageList = mainUserCall.execute().body();
            if (usageList.getUsage().size() <= 0){
                //account never used
                System.out.println("Account not used in the last 90 days.");
                return false;
            }
            List<List<Object>> usageEntries = usageList.getUsage();
            List<Object> usage = usageEntries.get(usageEntries.size()-1);
            String  dateString =  (String)(usage.get(0));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d", Locale.US);
            Date lastUsageDate =
                    Date.from(LocalDate.parse(dateString, dtf).atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.format("Account last used on %s\n", lastUsageDate.toString());
            if (lastUsageDate.before(cutoffDate)) {
                return false;
            } else {
                return true;
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    private static List<SauceUser> getIdleSubAccounts(int days, String parentUsername, SauceLabsService service){
        List<SauceUser> subUsers = getSubAccounts(service, parentUsername);
        List<SauceUser> idleUsers = new ArrayList<SauceUser>();
        boolean active = false;
        for (SauceUser user:subUsers){
            System.out.println("===============================================================");
            System.out.format("Username: %s, Email: %s\n", user.getUsername(), user.getEmail());
            active = accountUsedInTheLast(days, user.getUsername(), service);
            System.out.format("Status Active: %b\n", active);
            if (!active) {
                idleUsers.add(user);
            }
            System.out.println("===============================================================");
        }
        return idleUsers;
    }

    private static void deleteIdleSubAccounts(int days, String parentUsername, SauceLabsService service){
        List<SauceUser> subUsers = getSubAccounts(service, parentUsername);
        List<SauceUser> idleUsers = new ArrayList<SauceUser>();
        boolean active = false;
        System.out.println("====================Checking Idle Users=======================");
        for (SauceUser user:subUsers){
            System.out.println("=============================================================");
            System.out.format("Username: %s, Email: %s\n", user.getUsername(), user.getEmail());
            List<String> tunnelIds = getUserTunnelIds(service, user.getUsername());
            System.out.format("Tunnels: %s\n", tunnelIds.stream().collect(Collectors.joining(",")));
            active = accountUsedInTheLast(days, user.getUsername(), service);
            System.out.format("Status Active: %b\n", active);
            System.out.println("User tree:");
            printUserTree(service, user.getUsername(), true);
            if (!active && tunnelIds.get(0).equalsIgnoreCase("None")) {
                System.out.format("This user has been idle for more than %d days and has no tunnels running", days);
                System.out.format("Are you sure you'd like to add user \"%s\" to the deletion list? Yes/NO\n",
                        user.getUsername());
                String response = System.console().readLine();
                if (response.equalsIgnoreCase("yes")) {
                    idleUsers.add(user);
                }
            }
        }
        System.out.println("====================Deleting Idle Users=======================");
        for (SauceUser user:idleUsers){
            System.out.println("=============================================================");
            System.out.format("Username: %s, Email: %s\n", user.getUsername(), user.getEmail());
            active = accountUsedInTheLast(days, user.getUsername(), service);
            System.out.format("Status Active: %b\n", active);
            if (!active) {
                System.out.format("Are you sure you'd like to delete user \"%s\"? Yes/NO\n", user.getUsername());
                String response = System.console().readLine();
                if (response.equalsIgnoreCase("yes")) {
                    System.out.format("Deleting user %s, email: %s \n", user.getUsername(), user.getEmail());
                    deleteUser(service, user);
                }
            }
        }
    }
    private static void deleteUser(SauceLabsService service, SauceUser userToDelete){
        List<String> usernameList = new ArrayList<>();
        usernameList.add(userToDelete.getUsername());
        UsersToDelete usersToDelete = new UsersToDelete(usernameList);
        boolean success = false;
        try {
            Call<List<String>> subAccountsCall = service.deleteUsers(usersToDelete);
            Response res = subAccountsCall.execute();
            List<?> deletedUsers;
            if (res.code() == 200){
                if(res.body() instanceof ArrayList<?>){
                    deletedUsers = (ArrayList<?>)(res.body());
                } else {
                    throw new Exception("Invalid response");
                }
                for (Object user:deletedUsers){
                    if(user instanceof String && ((String)user).contentEquals(userToDelete.getUsername())){
                        System.out.format("User %s deleted successfully!\n", userToDelete.getUsername());
                        success = true;
                        break;
                    }
                }
                if(!success){
                    System.err.format("User %s deletion FAILED!\n", userToDelete.getUsername());
                }
            } else {
                System.err.format("User %s deletion FAILED!\nError code %d\n", userToDelete.getUsername(), res.code());
            }
        } catch (Exception e) {
            System.err.format("User %s deletion FAILED!\n", userToDelete.getUsername());
            e.printStackTrace();
        }
    }

    private static List<String> getUserTunnelIds(SauceLabsService service, String username){
        List<String> tunnelIds = null;
        try {
            Call<List<String>> tunnelCall = service.getUserActiveTunnels(username);
            Response<List<String>> res = tunnelCall.execute();
            if (res.isSuccessful()){
                tunnelIds = res.body();
            } else {
                tunnelIds = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (tunnelIds != null && tunnelIds.size() == 0)
            tunnelIds.add("None");
        return tunnelIds;
    }
}
