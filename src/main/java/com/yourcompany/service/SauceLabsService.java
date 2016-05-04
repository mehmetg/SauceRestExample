package com.yourcompany.service;

import com.yourcompany.models.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehmetgerceker on 4/7/16.
 */
public interface SauceLabsService {
    @GET("users/{username}")
    Call<SauceUser> getUser(@Path("username") String username);

    @GET("users/{username}/list-subaccounts")
    Call<SauceSubUserList> getSubAccountsList(@Path("username") String username);

    @GET("users/{username}/subaccounts")
    Call<List<SauceUser>> getSubAccounts(@Path("username") String username);

    @GET("users/{username}/activity")
    Call<Activity> getUserActivity(@Path("username") String username);
    @GET("users/{username}/usage")
    Call<UsageList> getUserUsage(@Path("username") String username);

    @GET("{username}/tunnels")
    Call<List<String>> getUserActiveTunnels(@Path("username") String username);

    @HTTP(method = "DELETE", hasBody = true, path = "users")
    Call<List<String>> deleteUsers(@Body UsersToDelete usersToDelete);
}

