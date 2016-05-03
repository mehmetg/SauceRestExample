package com.yourcompany.service;

import com.yourcompany.models.SauceSubUsers;
import com.yourcompany.models.SauceUser;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by mehmetgerceker on 4/7/16.
 */
public interface SauceLabsService {
    @GET("users/{username}")
    Call<SauceUser> getUser(@Path("username") String username);

    @GET("users/{username}/list-subaccounts")
    Call<SauceSubUsers> getSubAccountsList(@Path("username") String username);

    @GET("users/{username}/subaccounts")
    Call<List<SauceUser>> getSubAccounts(@Path("username") String username);
}

