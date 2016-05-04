package com.yourcompany.service;

import com.yourcompany.models.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    @GET("users/{username}/tunnels")
    Call<List<String>> getUserActiveTunnels(@Path("username") String username);

    @GET("users/{username}/tunnels{tunnelId")
    Call<Tunnel> getUserTunnel(@Path("username") String username, @Path("tunnelId") String tunnelId);

}

