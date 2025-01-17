package com.iacd.socioinfonavit.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static Retrofit retrofit = null;
    public static  String BASE_URL = "https://staging.api.socioinfonavit.io/api/v1/";
    private static Gson gson;
    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
