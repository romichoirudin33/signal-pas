package com.example.jakatarup;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultAssessmentActivity extends AppCompatActivity {

    TextView txt_nama_lengkap, txt_jenis_kelamin, txt_tindak_pidana, txt_hukuman, txt_kode, txt_definisi;
    Button btn_selesai;

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

        init();

        Bundle e = getIntent().getExtras();
        txt_nama_lengkap.setText(e.getString("nama_lengkap"));
        txt_jenis_kelamin.setText(e.getString("jenis_kelamin"));
        txt_tindak_pidana.setText(e.getString("tindak_pidana"));
        txt_hukuman.setText(e.getString("hukuman"));
        txt_kode.setText(e.getString("kode"));
        txt_definisi.setText(e.getString("definisi"));

        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDatabase();
            }
        });
    }

    private void sendDatabase() {
        Toast.makeText(getApplicationContext(), "Data di posting !!", Toast.LENGTH_SHORT).show();
    }

    private void init() {

        txt_nama_lengkap = findViewById(R.id.txt_nama_lengkap);
        txt_jenis_kelamin = findViewById(R.id.txt_jenis_kelamin);
        txt_tindak_pidana = findViewById(R.id.txt_tindak_pidana);
        txt_hukuman = findViewById(R.id.txt_hukuman);
        txt_kode = findViewById(R.id.txt_kode);
        txt_definisi = findViewById(R.id.txt_definisi);

        btn_selesai = findViewById(R.id.btn_selesai);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}