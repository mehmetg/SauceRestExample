package com.yourcompany;


import com.yourcompany.models.SauceSubUserList;
import com.yourcompany.models.SauceUser;
import com.yourcompany.models.UsageList;
import com.yourcompany.service.SauceLabsService;
import com.yourcompany.service.SauceLabsServiceGenerator;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        printAccountNotUsedSince(service, "mehmetg", 14);
    }


    private static void printSubAccounts(SauceLabsService service, String parentUsername){
        try{
            Call<List<SauceUser>> subAccountCall = service.getSubAccounts(parentUsername);
            List<SauceUser> subUsers = subAccountCall.execute().body();
            for(SauceUser user:subUsers){
                System.out.format("Username: %s, Email: %s\n", user.getUsername(), user.getEmail());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void printUserTree(SauceLabsService service, String username) {
        try{
            Call<SauceUser> mainUserCall = service.getUser(username);
            SauceUser user = mainUserCall.execute().body();
            System.out.format("Username: %s, Email: %s\n", user.getUsername(), user.getEmail());
            printUserTree(service, username, "");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void printUserTree(SauceLabsService service, String username, String levelPad) throws IOException{
        Call<SauceSubUserList> subAccountsCall = service.getSubAccountsList(username);
        List<SauceUser> subUsers = subAccountsCall.execute().body().getSubUsers();
        for(SauceUser user:subUsers){
            String childPad = levelPad+"\t";
            System.out.format("%s-Username: %s, Email: %s\n", childPad, user.getUsername(), user.getEmail());
            printUserTree(service, user.getUsername(), childPad);
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
}
