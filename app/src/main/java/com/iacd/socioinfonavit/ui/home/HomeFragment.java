package com.iacd.socioinfonavit.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iacd.socioinfonavit.AdapterWallets;
import com.iacd.socioinfonavit.LoginActivity;
import com.iacd.socioinfonavit.MainActivity;
import com.iacd.socioinfonavit.R;
import com.iacd.socioinfonavit.model.Benevits;
import com.iacd.socioinfonavit.model.LandingBenevits;
import com.iacd.socioinfonavit.model.Login;
import com.iacd.socioinfonavit.model.User;
import com.iacd.socioinfonavit.model.UserData;
import com.iacd.socioinfonavit.model.Wallets;
import com.iacd.socioinfonavit.webservice.Client;
import com.iacd.socioinfonavit.webservice.webServices;

import java.util.ArrayList;
import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

    ArrayList<Wallets> userWalletList = new ArrayList<>();
    ArrayList<Benevits> userBenevistList = new ArrayList<>();
    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.homeRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterWallets adapterWallets = new AdapterWallets();

        userWalletList = new ArrayList<>();

        Retrofit retrofitClient = Client.getRetrofitClient();
        webServices webServices = retrofitClient.create(webServices.class);
        Call<ArrayList<Wallets>> call = webServices.getWallets();
        call.enqueue(new Callback<ArrayList<Wallets>>() {
            @Override
            public void onResponse(Call<ArrayList<Wallets>> call, Response<ArrayList<Wallets>> response) {
                userWalletList.addAll(response.body());
                adapterWallets.setListWallets(userWalletList);
                recyclerView.setAdapter(adapterWallets);
            }

            @Override
            public void onFailure(Call<ArrayList<Wallets>> call, Throwable t) {

            }
        });

        userBenevistList = new ArrayList<>();

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("sharedPreferences", 0);
        Call<LandingBenevits> newCall = webServices.getAllBenevits(sharedPreferences.getString("user_token", ""));
        newCall.enqueue(new Callback<LandingBenevits>() {
            @Override
            public void onResponse(Call<LandingBenevits> newCall, Response<LandingBenevits> response) {
                userBenevistList.addAll(response.body().getUnlockedBenevits());
                for (int i = 0; i < userBenevistList.size(); i++)
                {
                    userBenevistList.get(i).setLocked(false);
                }
                userBenevistList.addAll(response.body().getLockedBenevits());
                adapterWallets.setListBenevits(userBenevistList);

            }

            @Override
            public void onFailure(Call<LandingBenevits> call, Throwable t) {

            }
        });


        return root;
    }

      /*  private void getWallets() {
        AdapterWallets adapterWallets = new AdapterWallets();
        Retrofit retrofitClient = Client.getRetrofitClient();
        webServices webServices = retrofitClient.create(webServices.class);
        Call<ArrayList<Wallets>> call = webServices.getWallets();
        call.enqueue(new Callback<ArrayList<Wallets>>() {
            @Override
            public void onResponse(Call<ArrayList<Wallets>> call, Response<ArrayList<Wallets>> response) {
                userWalletList.addAll(response.body());
                adapterWallets.setListWallets(userWalletList);
                recyclerView.setAdapter(adapterWallets);
            }

            @Override
            public void onFailure(Call<ArrayList<Wallets>> call, Throwable t) {

            }
        });
        }

        private void getBenevits() {
        Retrofit retrofitClient = Client.getRetrofitClient();
        webServices webServices = retrofitClient.create(webServices.class);
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("sharedPreferences", 0);
        Call<LandingBenevits> call = webServices.getAllBenevits(sharedPreferences.getString("user_token", ""));
        call.enqueue(new Callback<LandingBenevits>() {
            @Override
            public void onResponse(Call<LandingBenevits> call, Response<LandingBenevits> response) {
                userBenevistList.addAll(response.body().getUnlockedBenevits());
                for (int i = 0; i < userBenevistList.size(); i++)
                {
                    userBenevistList.get(i).setLocked(false);
                }
                userBenevistList.addAll(response.body().getLockedBenevits());


            }

            @Override
            public void onFailure(Call<LandingBenevits> call, Throwable t) {

            }
        });


        }*/


}