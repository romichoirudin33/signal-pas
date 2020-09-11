package com.example.jakatarup;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;

public class MaintanceActivity extends AppCompatActivity {

    TextView txt_keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintance);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        txt_keterangan = findViewById(R.id.txt_keterangan);

        String keterangan = getIntent().getStringExtra("keterangan") == null ?  "" : getIntent().getStringExtra("keterangan");
        txt_keterangan.setText(keterangan);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}