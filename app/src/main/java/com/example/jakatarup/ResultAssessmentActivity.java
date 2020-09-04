package com.example.jakatarup;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.example.jakatarup.Models.Tahanan;
import com.example.jakatarup.Models.Token;
import com.example.jakatarup.Retrofit.ApiClient;
import com.example.jakatarup.Retrofit.AuthInterface;
import com.example.jakatarup.Retrofit.TahananInterface;
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

public class ResultAssessmentActivity extends AppCompatActivity {

    TextView txt_nama_lengkap, txt_jenis_kelamin, txt_tindak_pidana, txt_hukuman, txt_definisi;
    Button btn_selesai;

    String nama_lengkap, jenis_kelamin, kode, ttl, alamat, agama, kewarganegaraan, residivis, tindak_pidana, hukuman, definisi;
    int user_id, jml_residivis;

    Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_assessment);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        util = new Util(this);

        init();

        Bundle e = getIntent().getExtras();
        txt_nama_lengkap.setText(e.getString("nama_lengkap"));
        txt_jenis_kelamin.setText(e.getString("jenis_kelamin"));
        txt_tindak_pidana.setText(e.getString("tindak_pidana"));
        txt_hukuman.setText(e.getString("hukuman"));
        txt_definisi.setText(e.getString("definisi"));

        nama_lengkap = e.getString("nama_lengkap");
        jenis_kelamin = e.getString("jenis_kelamin");
        tindak_pidana = e.getString("tindak_pidana");
        hukuman = e.getString("hukuman");
        definisi = e.getString("definisi");
        ttl = e.getString("ttl");
        alamat = e.getString("alamat");
        agama = e.getString("agama");
        kewarganegaraan = e.getString("kewarganegaraan");
        residivis = e.getString("residivis");
        user_id = e.getInt("user_id");
        jml_residivis = e.getInt("jml_residivis");
        kode = e.getString("kode");

        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDatabase();
            }
        });
    }

    TahananInterface tahananInterface;
    private void sendDatabase() {
        util.showDialog("Tunggu Sebentar...");
        tahananInterface = ApiClient.getClient().create(TahananInterface.class);

        Call<Tahanan> call = tahananInterface.store(
                nama_lengkap, ttl, alamat, jenis_kelamin, agama, kewarganegaraan, tindak_pidana, hukuman, residivis, jml_residivis, definisi, user_id
        );
        call.enqueue(new Callback<Tahanan>() {
            @Override
            public void onResponse(Call<Tahanan> call, Response<Tahanan> response) {
                util.hideDialog();
                if (response.code() == 201) {
                    Toast.makeText(getApplicationContext(), "Data berhasil tersimpan di database", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
                finish();
            }

            @Override
            public void onFailure(Call<Tahanan> call, Throwable t) {
                util.hideDialog();
                Log.e("RequestFailed", t.getMessage());
                Toast.makeText(getApplicationContext(), fetchErrorMessage(t), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {

        txt_nama_lengkap = findViewById(R.id.txt_nama_lengkap);
        txt_jenis_kelamin = findViewById(R.id.txt_jenis_kelamin);
        txt_tindak_pidana = findViewById(R.id.txt_tindak_pidana);
        txt_hukuman = findViewById(R.id.txt_hukuman);
        txt_definisi = findViewById(R.id.txt_definisi);

        btn_selesai = findViewById(R.id.btn_selesai);
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