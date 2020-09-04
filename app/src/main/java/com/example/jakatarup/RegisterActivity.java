package com.example.jakatarup;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.example.jakatarup.Models.Responses;
import com.example.jakatarup.Models.Token;
import com.example.jakatarup.Retrofit.ApiClient;
import com.example.jakatarup.Retrofit.AuthInterface;
import com.example.jakatarup.Utils.Util;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.concurrent.TimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText ed_nama_lengkap, ed_nip, ed_jabatan, ed_upt, ed_phone, ed_password, ed_ulangi_password;
    Button btn_selesai;

    RadioGroup[] radioGroups = new RadioGroup[46];
    double[] assesstment = new double[46];

    Util util;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        util = new Util(this);

        init();

        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ed_password.getText().toString().equals(ed_ulangi_password.getText().toString())) {
                    Snackbar.make(v, "Password tidak sama !", Snackbar.LENGTH_SHORT).show();
                }else if (ed_password.getText().toString().equals("")) {
                    Snackbar.make(v, "Password tidak boleh kosong !", Snackbar.LENGTH_SHORT).show();
                }else{
                    if (ed_nama_lengkap.getText().toString().equals("") && ed_nip.getText().toString().equalsIgnoreCase("")){
                        Snackbar.make(v, "Nama dan NIP tidak boleh kosong !", Snackbar.LENGTH_SHORT).show();
                    }else{
                        hitung();
                    }
                }
            }
        });
    }

    private void hitung() {
        score = 0;
        for (int i = 1; i <= 45; i++) {
            score += assesstment[i];
        }
        register(score);
    }

    AuthInterface authInterface;
    private void register(int score) {
        util.showDialog("Tunggu Sebentar...");
        authInterface = ApiClient.getClient().create(AuthInterface.class);
        String name = ed_nama_lengkap.getText().toString();
        String username = ed_nip.getText().toString();
        String email = username+"@mail.com";
        String password = ed_password.getText().toString();
        String jabatan = ed_jabatan.getText().toString();
        String upt = ed_upt.getText().toString();
        String phone = ed_phone.getText().toString();
        Call<Responses> call = authInterface.register(name, username, email, password, jabatan, upt, phone, score);
        call.enqueue(new Callback<Responses>() {
            @Override
            public void onResponse(Call<Responses> call, Response<Responses> response) {
                util.hideDialog();
                if (response.code() == 200) {
                    Toast.makeText(getApplicationContext(), "Pendaftaran berhasil, silahkan tunggu admin untuk proses verifikasi", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Terjadi kesalahan, hubungi pengembang", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Responses> call, Throwable t) {
                util.hideDialog();
                Log.e("RequestFailed", t.getMessage());
                Toast.makeText(getApplicationContext(), fetchErrorMessage(t), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        ed_nama_lengkap = findViewById(R.id.ed_nama_lengkap);
        ed_nip = findViewById(R.id.ed_nip);
        ed_jabatan = findViewById(R.id.ed_jabatan);
        ed_upt = findViewById(R.id.ed_upt);
        ed_phone = findViewById(R.id.ed_phone);
        ed_password = findViewById(R.id.ed_password);
        ed_ulangi_password = findViewById(R.id.ed_ulangi_password);

        btn_selesai = findViewById(R.id.btn_selesai);

        for (int i = 1; i <= 45; i++) {
            assesstment[i] = 0;

            String editTextID = "radio_" + i + "_group";
            int resID = getResources().getIdentifier(editTextID
                    , "id", RegisterActivity.this.getPackageName());
            radioGroups[i] = (RadioGroup) findViewById(resID);
            final int finalI = i;
            radioGroups[i].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton radioButton = (RadioButton) findViewById(checkedId);
                    if (radioButton.getText().toString().equalsIgnoreCase("SS")) {
                        assesstment[finalI] = 4;
                    } else if (radioButton.getText().toString().equalsIgnoreCase("S")) {
                        assesstment[finalI] = 3;
                    } else if (radioButton.getText().toString().equalsIgnoreCase("TS")) {
                        assesstment[finalI] = 2;
                    } else if (radioButton.getText().toString().equalsIgnoreCase("STS")) {
                        assesstment[finalI] = 1;
                    } else {
                        assesstment[finalI] = 0;
                    }
                }
            });
        }
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
        onBackPressed();
        return true;
    }
}