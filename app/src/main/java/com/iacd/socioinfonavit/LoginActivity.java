package com.iacd.socioinfonavit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iacd.socioinfonavit.model.Login;
import com.iacd.socioinfonavit.model.User;
import com.iacd.socioinfonavit.model.UserData;
import com.iacd.socioinfonavit.webservice.Client;
import com.iacd.socioinfonavit.webservice.webServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button bLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.email_login);
        etPassword = (EditText) findViewById(R.id.password_login);
        bLogin = (Button) findViewById(R.id.button_login);

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()>0 && etPassword.getText().length()>0)
                {
                    bLogin.setEnabled(true);
                    bLogin.setBackground(getDrawable(R.drawable.rounded_button));
                } else {
                    bLogin.setEnabled(false);
                    bLogin.setBackground(getDrawable(R.drawable.disabled_rounded_button));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()>0 && etEmail.getText().length()>0)
                {
                    bLogin.setEnabled(true);
                    bLogin.setBackground(getDrawable(R.drawable.rounded_button));
                } else {
                    bLogin.setEnabled(false);
                    bLogin.setBackground(getDrawable(R.drawable.disabled_rounded_button));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN  && i == KeyEvent.KEYCODE_ENTER)
                {
                    loginCall(etEmail.getText().toString(), etPassword.getText().toString());
                    return true;
                }
                return false;
            }

        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginCall(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });

    }

    public void loginCall(String email, String password){
        Retrofit retrofitClient = Client.getRetrofitClient();
        webServices webServices = retrofitClient.create(webServices.class);
        Call<Login> call = webServices.login(new User(new UserData(email, password)));
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.raw().code() == 401) {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Usuario y contraseña incorrectos.")
                            .setMessage("Intenta nuevamente.")
                            .setPositiveButton(android.R.string.ok, null)
                            .show();
                } else if (response.isSuccessful())
                    {
                        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", 0);
                        sharedPreferences.edit().putString("user_token", response.headers().get("Authorization").toString()).commit();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
            }

            @Override
                public void onFailure(Call<Login> call, Throwable t) {
                Log.d("Error: ", t.toString());
            }
        });
    }

}