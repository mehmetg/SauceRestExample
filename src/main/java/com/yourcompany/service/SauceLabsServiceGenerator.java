package com.yourcompany.service;

import okhttp3.*;
import okhttp3.internal.Util;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by mehmetgerceker on 4/7/16.
 */
public class SauceLabsServiceGenerator {

    private static final String API_BASE_URL = "https://saucelabs.com/rest/v1/";

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    private static OkHttpClient httpClient;

    public static <S> S createService(Class<S> serviceClass, String username, String password) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(JacksonConverterFactory.create());

        if (username != null && password != null) {
            String credentials = username + ":" + password;
            final String basic =
                    "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());

            httpClientBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", basic)
                            .header("Accept", "application/json")
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        ThreadPoolExecutor singleThreadPoolExecutor =  new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), Util.threadFactory("Custom OkHttp Dispatcher -- mehmetg", false));
        Dispatcher singleThreadDispatcher = new Dispatcher(singleThreadPoolExecutor);

        httpClient = httpClientBuilder.dispatcher(singleThreadDispatcher).build();
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
