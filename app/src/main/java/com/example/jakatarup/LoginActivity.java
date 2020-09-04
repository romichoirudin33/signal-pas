package com.example.jakatarup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jakatarup.Models.Token;
import com.example.jakatarup.Retrofit.ApiClient;
import com.example.jakatarup.Retrofit.AuthInterface;
import com.example.jakatarup.Utils.Util;
import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.TimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText ed_username, ed_password;
    Button btn_login;
    TextView btn_daftar;
    Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        util = new Util(this);

        init();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed_username.getText().toString().equals("") || ed_password.getText().toString().equals("")) {
                    Snackbar.make(view, "Inputan tidak boleh kosong!", Snackbar.LENGTH_SHORT).show();
                } else {
                    login(ed_username.getText().toString(), ed_password.getText().toString());
                }
            }
        });

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    AuthInterface authInterface;
    private void login(String username, String password) {
        util.showDialog("Tunggu Sebentar...");
        authInterface = ApiClient.getClient().create(AuthInterface.class);
        Call<Token> call = authInterface.getToken(username, password);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                util.hideDialog();
                if (response.code() == 200) {
                    boolean is_login = response.body().isLogin();
                    if (is_login){
                        String resToken = response.body().getAccessToken();
                        util.simpanToken(resToken);
                        Intent intent = new Intent(getApplicationContext(), AssessmentActivity.class);
                        intent.putExtra("nama_petugas", response.body().getName());
                        intent.putExtra("user_id", response.body().getId());
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "Terjadi kesalahan, hubungi pengembang", Toast.LENGTH_SHORT).show();
                }
                Log.d(util.TAG, response.toString());
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                util.hideDialog();
                Log.e("RequestFailed", t.getMessage());
                Toast.makeText(getApplicationContext(), fetchErrorMessage(t), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {

        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        btn_login = findViewById(R.id.btn_login);
        btn_daftar = findViewById(R.id.btn_daftar);

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    private String fetchErrorMessage(Throwable throwable) {
        util.hideDialog();
        String errorMsg = getResources().getString(R.string.error_msg_unknown);
        if (!isNetworkConnected()) {
            errorMsg = getResources().getString(R.string.error_msg_no_internet);
        } else if (throwable instanceof TimeoutException) {
            errorMsg = getResources().getString(R.string.error_msg_timeout);
        }

        return errorMsg;
    }

}