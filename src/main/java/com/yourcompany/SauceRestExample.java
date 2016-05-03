package com.yourcompany;


import com.yourcompany.models.SauceSubUsers;
import com.yourcompany.models.SauceUser;
import com.yourcompany.service.SauceLabsService;
import com.yourcompany.service.SauceLabsServiceGenerator;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by mehmetgerceker on 4/7/16.
 */
public class SauceRestExample {

    public static void main(String[] args) throws InterruptedException {
        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");

        SauceLabsService service =
                SauceLabsServiceGenerator.createService(SauceLabsService.class, username, accessKey);

        System.out.println("Flat Sub-Account List");
        System.out.println("============================");
        printSubAccounts(service, username);
        System.out.println("============================");
        System.out.println("Hierarchical Sub-Ac" +
                "count Tree");
        System.out.println("============================");
        printUserTree(service, username);
        System.out.println("============================");
    }


    private static void printSubAccounts(SauceLabsService service, String parentUsername){
        System.out.println("Username,Firstname,Lastname,Email");
        try{
            Call<List<SauceUser>> subAccountCall = service.getSubAccounts(parentUsername);
            List<SauceUser> subUsers = subAccountCall.execute().body();
            for(SauceUser user:subUsers){
                System.out.format("%s,%s,%s,%s\n", user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail());
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
        Call<SauceSubUsers> subAccountsCall = service.getSubAccountsList(username);
        List<SauceUser> subUsers = subAccountsCall.execute().body().getSubUsers();
        for(SauceUser user:subUsers){
            String childPad = levelPad+"\t";
            System.out.format("%s-Username: %s, Email: %s\n", childPad, user.getUsername(), user.getEmail());
            printUserTree(service, user.getUsername(), childPad);
        }
    }

}
