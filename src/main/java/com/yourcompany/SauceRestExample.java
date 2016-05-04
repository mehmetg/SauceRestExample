package com.yourcompany;


import com.yourcompany.models.SauceSubUserList;
import com.yourcompany.models.SauceUser;
import com.yourcompany.models.UsageList;
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
        System.out.println("Hierarchical Sub-Account Tree");
        System.out.println("============================");
        printUserTree(service, "ancesortaccounthere", true);
        System.out.println("============================");

    }


    private static void printSubAccounts(SauceLabsService service, String parentUsername){
        try{
            Call<List<SauceUser>> subAccountCall = service.getSubAccounts(parentUsername);
            List<SauceUser> subUsers = subAccountCall.execute().body();
            for(SauceUser user:subUsers){
                System.out.format("First Name: %s, Last Name: %s, Username: %s, Email: %s\n",
                        user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
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

    private static boolean printAccountNotUsedSince(SauceLabsService service, String username, int days){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -days);
        Date cutoffDate = cal.getTime();
        System.out.format("Cutoff date is %s.", cutoffDate.toString());
        try {
            Call<UsageList> mainUserCall = service.getUserUsage(username);
            UsageList usageList = mainUserCall.execute().body();
            if (usageList.getUsage().size() < 0){
                //account never used
                System.out.println("Account not used in the last 90 days.");
                return true;
            }
            String  dateString =  (String)(usageList.getUsage().get(0).get(0));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-DD", Locale.US);
            Date lastUsageDate =
                    Date.from(LocalDate.parse(dateString, dtf).atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.format("Account last used on %s", lastUsageDate.toString());
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
        if (tunnelIds.size() == 0)
            tunnelIds.add("None");
        return tunnelIds;
    }
}
