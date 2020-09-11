package com.iacd.socioinfonavit.webservice;

import com.iacd.socioinfonavit.model.LandingBenevits;
import com.iacd.socioinfonavit.model.Login;
import com.iacd.socioinfonavit.model.User;
import com.iacd.socioinfonavit.model.Wallets;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface webServices {
    @POST("login")
    Call<Login> login(@Body User user);

    @GET("member/wallets")
    Call<ArrayList<Wallets>> getWallets();

    @GET("member/landing_benevits")
    Call<LandingBenevits> getAllBenevits(@Header("Authorization")String token);

    @DELETE("logout")
    Call<Response<String>> logout();

}
