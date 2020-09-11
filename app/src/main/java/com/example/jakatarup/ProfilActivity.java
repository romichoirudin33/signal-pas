package com.example.jakatarup;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.example.jakatarup.Models.Responses;
import com.example.jakatarup.Models.User;
import com.example.jakatarup.Retrofit.ApiClient;
import com.example.jakatarup.Retrofit.AuthInterface;
import com.example.jakatarup.Utils.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilActivity extends AppCompatActivity {

    TextView txt_nama_lengkap, txt_nip, txt_jabatan, txt_upt, txt_phone;
    Button btn_logout;

    Util util;

    AuthInterface authInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        util = new Util(this);

        txt_nama_lengkap = findViewById(R.id.txt_nama_lengkap);
        txt_nip = findViewById(R.id.txt_nip);
        txt_jabatan = findViewById(R.id.txt_jabatan);
        txt_upt = findViewById(R.id.txt_upt);
        txt_phone = findViewById(R.id.txt_phone);

        btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                util.LogoutSession();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        util.showDialog("Tunggu Sebentar ... ");
        authInterface = ApiClient.getClient().create(AuthInterface.class);
        Call<User> call = authInterface.getUser(util.getToken());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                util.hideDialog();
                if (response.code() == 200) {
                    txt_nama_lengkap.setText(response.body().getName());
                    txt_nip.setText(response.body().getUsername());
                    txt_jabatan.setText(response.body().getJabatan());
                    txt_upt.setText(response.body().getUpt());
                    txt_phone.setText(response.body().getPhone());
                }else{
                    Toast.makeText(getApplicationContext(), "Terjadi kesalahan, hubungi pengembang", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                util.hideDialog();
                Log.e("RequestFailed", t.getMessage());
                Toast.makeText(getApplicationContext(), fetchErrorMessage(t), Toast.LENGTH_SHORT).show();
            }
        });
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


    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
//        onBackPressed();
        return true;
    }
}