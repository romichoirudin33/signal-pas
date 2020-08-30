package com.example.jakatarup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Arrays;

public class AssessmentActivity extends AppCompatActivity {

    EditText ed_nama_lengkap, ed_tindak_pidana, ed_hukuman;
    RadioButton radio_jk_pria;

    RadioButton radio_a1_ya;
    RadioButton radio_a2_ya;
    RadioButton radio_a3_ya;
    RadioButton radio_a4_ya;
    RadioButton radio_a5_ya;
    RadioButton radio_a6_ya;
    RadioButton radio_a7_ya;
    RadioButton radio_a8_ya;
    RadioButton radio_a9_ya;

    RadioButton radio_b1_ya;
    RadioButton radio_b2_ya;
    RadioButton radio_b3_ya;
    RadioButton radio_b4_ya;
    RadioButton radio_b5_ya;
    RadioButton radio_b6_ya;
    RadioButton radio_b7_ya;
    RadioButton radio_b8_ya;
    RadioButton radio_b9_ya;
    RadioButton radio_b10_ya;
    RadioButton radio_b11_ya;
    RadioButton radio_b12_ya;
    RadioButton radio_b13_ya;
    RadioButton radio_b14_ya;

    RadioButton radio_c1_ya;
    RadioButton radio_c2_ya;
    RadioButton radio_c3_ya;
    RadioButton radio_c4_ya;
    RadioButton radio_c5_ya;
    RadioButton radio_c6_ya;

    RadioButton radio_d1_ya;
    RadioButton radio_d2_ya;
    RadioButton radio_d3_ya;
    RadioButton radio_d4_ya;
    RadioButton radio_d5_ya;
    RadioButton radio_d6_ya;
    RadioButton radio_d7_ya;
    RadioButton radio_d8_ya;
    RadioButton radio_d9_ya;
    RadioButton radio_d10_ya;
    RadioButton radio_d11_ya;
    RadioButton radio_d12_ya;

    Button btn_selesai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        init();

        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung();
//                String nama_lengkap = ed_nama_lengkap.getText().toString();
//                if (!nama_lengkap.equalsIgnoreCase("")){
//                    hitung();
//                }else{
//                    Toast.makeText(getApplicationContext(), "Nama harus di isi !!", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    public String hitung_a() {
        double skor = 0.0;
        if (radio_a1_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_a2_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_a3_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_a4_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_a5_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_a6_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_a7_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_a8_ya.isChecked()) {
            skor += 2.1;
        }
        if (radio_a9_ya.isChecked()) {
            skor += 2;
        }

        String wbp;
        if (skor < 1.5) {
            wbp = "R";
        } else if (skor <= 4.6) {
            wbp = "S";
        } else {
            wbp = "T";
        }
        return wbp;
    }

    public String hitung_b() {
        double skor = 0.0;
        if (radio_b1_ya.isChecked()) {
            skor += 0.8;
        }
        if (radio_b2_ya.isChecked()) {
            skor += 1.3;
        }
        if (radio_b3_ya.isChecked()) {
            skor += 1.1;
        }
        if (radio_b4_ya.isChecked()) {
            skor += 1.7;
        }
        if (radio_b5_ya.isChecked()) {
            skor += 1.1;
        }
        if (radio_b6_ya.isChecked()) {
            skor += 2.9;
        }
        if (radio_b7_ya.isChecked()) {
            skor += 2.8;
        }
        if (radio_b8_ya.isChecked()) {
            skor += 3.7;
        }
        if (radio_b9_ya.isChecked()) {
            skor += 1.7;
        }
        if (radio_b10_ya.isChecked()) {
            skor += 1.9;
        }
        if (radio_b11_ya.isChecked()) {
            skor += 2.9;
        }
        if (radio_b12_ya.isChecked()) {
            skor += 4;
        }
        if (radio_b13_ya.isChecked()) {
            skor += 3.3;
        }
        if (radio_b14_ya.isChecked()) {
            skor += 1.9;
        }

        String wbp;
        if (skor < 4) {
            wbp = "R";
        } else if (skor <= 7.9) {
            wbp = "S";
        } else {
            wbp = "T";
        }
        return wbp;
    }

    public String hitung_c() {
        double skor = 0.0;
        if (radio_c1_ya.isChecked()) {
            skor += 3.1;
        }
        if (radio_c2_ya.isChecked()) {
            skor += 5;
        }
        if (radio_c3_ya.isChecked()) {
            skor += 3.8;
        }
        if (radio_c4_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_c5_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_c6_ya.isChecked()) {
            skor += 1.9;
        }

        String wbp;
        if (skor < 1.6) {
            wbp = "R";
        } else if (skor <= 2.3) {
            wbp = "S";
        } else {
            wbp = "T";
        }
        return wbp;
    }

    public String hitung_d() {
        double skor = 0.0;
        if (radio_d1_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_d2_ya.isChecked()) {
            skor += 1.5;
        }
        if (radio_d3_ya.isChecked()) {
            skor += 2.1;
        }
        if (radio_d4_ya.isChecked()) {
            skor += 2.4;
        }
        if (radio_d5_ya.isChecked()) {
            skor += 2.4;
        }
        if (radio_d6_ya.isChecked()) {
            skor += 2.2;
        }
        if (radio_d7_ya.isChecked()) {
            skor += 2.3;
        }
        if (radio_d8_ya.isChecked()) {
            skor += 2.3;
        }
        if (radio_d9_ya.isChecked()) {
            skor += 2;
        }
        if (radio_d10_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_d11_ya.isChecked()) {
            skor += 1.4;
        }
        if (radio_d12_ya.isChecked()) {
            skor += 1.4;
        }

        String wbp;
        if (skor < 4) {
            wbp = "R";
        } else if (skor <= 7.9) {
            wbp = "S";
        } else {
            wbp = "T";
        }
        return wbp;
    }

    private void hitung() {

        String kelas = hitung_a() + hitung_b() + hitung_c() + hitung_d();
//        Toast.makeText(getApplicationContext(), "Kelas !!" + kelas, Toast.LENGTH_SHORT).show();

        String[] super_maximum = {"TTTT", "TTTS", "TTTR", "TSTT", "TSTS", "TSTR", "TRTT", "TRTS", "TRTR"};
        String[] maximum = {
                "TTST", "TTSS", "TTSR", "TTRT", "TSST", "TSSS", "TSSR", "TRST", "TRSS", "TRSR",
                "STTT", "STTS", "STTR", "STST", "STSS", "STSR", "SSTT", "SSTS", "SSTR", "SRTT",
                "SRTS", "SRTR"
        };
        String[] medium = {
                "TTRS", "TTRR", "TSRT", "TSRS", "TSRR", "TRRT", "TRRS", "TRRR", "STRT", "STRS",
                "STRR", "SSST", "SSSS", "SSSR", "SSRT", "SSRS", "SSRR", "SRST", "SRSS", "SRSR",
                "SRRT", "SRRS", "SRRR", "RTTT", "RTTS", "RTTR", "RTST", "RTSS", "RTSR", "RTRT",
                "RTRS", "RTRR", "RSTT", "RSTS", "RSTR", "RSST", "RSSS", "RSSR", "RSRT", "RSRS",
                "RSRR", "RRTT", "RRTS", "RRTR", "RRST", "RRSS", "RRSR"
        };
        String[] minimum = {"RRRT", "RRRS", "RRRR"};

        String definisi = "";
        if (Arrays.asList(super_maximum).contains(kelas)){
            definisi = "LAPAS SUPER MAXIMUM SECURITY";
            Toast.makeText(getApplicationContext(), "Kelas !!" + kelas + " " + definisi, Toast.LENGTH_SHORT).show();
        }
        if (Arrays.asList(maximum).contains(kelas)){
            definisi = "LAPAS MAXIMUM SECURITY";
            Toast.makeText(getApplicationContext(), "Kelas !!" + kelas + " " + definisi, Toast.LENGTH_SHORT).show();
        }
        if (Arrays.asList(medium).contains(kelas)){
            definisi = "LAPAS MEDIUM SECURITY";
            Toast.makeText(getApplicationContext(), "Kelas !!" + kelas + " " + definisi, Toast.LENGTH_SHORT).show();
        }
        if (Arrays.asList(minimum).contains(kelas)){
            definisi = "LAPAS MINIMUM SECURITY";
            Toast.makeText(getApplicationContext(), "Kelas !!" + kelas + " " + definisi, Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this, ResultAssessmentActivity.class);
        intent.putExtra("nama_lengkap", ed_nama_lengkap.getText().toString());
        intent.putExtra("jenis_kelamin", radio_jk_pria.isChecked() ? "Laki-laki" : "Perempuan");
        intent.putExtra("tindak_pidana", ed_tindak_pidana.getText().toString());
        intent.putExtra("hukuman", ed_hukuman.getText().toString());
        intent.putExtra("kode", kelas);
        intent.putExtra("definisi", definisi);
        startActivity(intent);
        finish();
    }

    private void init() {

        ed_nama_lengkap = findViewById(R.id.ed_nama_lengkap);
        ed_tindak_pidana = findViewById(R.id.ed_tindak_pidana);
        ed_hukuman = findViewById(R.id.ed_hukuman);
        radio_jk_pria = findViewById(R.id.radio_jk_pria);

        radio_a1_ya = findViewById(R.id.radio_a1_ya);
        radio_a2_ya = findViewById(R.id.radio_a2_ya);
        radio_a3_ya = findViewById(R.id.radio_a3_ya);
        radio_a4_ya = findViewById(R.id.radio_a4_ya);
        radio_a5_ya = findViewById(R.id.radio_a5_ya);
        radio_a6_ya = findViewById(R.id.radio_a6_ya);
        radio_a7_ya = findViewById(R.id.radio_a7_ya);
        radio_a8_ya = findViewById(R.id.radio_a8_ya);
        radio_a9_ya = findViewById(R.id.radio_a9_ya);

        radio_b1_ya = findViewById(R.id.radio_b1_ya);
        radio_b2_ya = findViewById(R.id.radio_b2_ya);
        radio_b3_ya = findViewById(R.id.radio_b3_ya);
        radio_b4_ya = findViewById(R.id.radio_b4_ya);
        radio_b5_ya = findViewById(R.id.radio_b5_ya);
        radio_b6_ya = findViewById(R.id.radio_b6_ya);
        radio_b7_ya = findViewById(R.id.radio_b7_ya);
        radio_b8_ya = findViewById(R.id.radio_b8_ya);
        radio_b9_ya = findViewById(R.id.radio_b9_ya);
        radio_b10_ya = findViewById(R.id.radio_b10_ya);
        radio_b11_ya = findViewById(R.id.radio_b11_ya);
        radio_b12_ya = findViewById(R.id.radio_b12_ya);
        radio_b13_ya = findViewById(R.id.radio_b13_ya);
        radio_b14_ya = findViewById(R.id.radio_b14_ya);

        radio_c1_ya = findViewById(R.id.radio_c1_ya);
        radio_c2_ya = findViewById(R.id.radio_c2_ya);
        radio_c3_ya = findViewById(R.id.radio_c3_ya);
        radio_c4_ya = findViewById(R.id.radio_c4_ya);
        radio_c5_ya = findViewById(R.id.radio_c5_ya);
        radio_c6_ya = findViewById(R.id.radio_c6_ya);

        radio_d1_ya = findViewById(R.id.radio_d1_ya);
        radio_d2_ya = findViewById(R.id.radio_d2_ya);
        radio_d3_ya = findViewById(R.id.radio_d3_ya);
        radio_d4_ya = findViewById(R.id.radio_d4_ya);
        radio_d5_ya = findViewById(R.id.radio_d5_ya);
        radio_d6_ya = findViewById(R.id.radio_d6_ya);
        radio_d7_ya = findViewById(R.id.radio_d7_ya);
        radio_d8_ya = findViewById(R.id.radio_d8_ya);
        radio_d9_ya = findViewById(R.id.radio_d9_ya);
        radio_d10_ya = findViewById(R.id.radio_d10_ya);
        radio_d11_ya = findViewById(R.id.radio_d11_ya);
        radio_d12_ya = findViewById(R.id.radio_d12_ya);

        btn_selesai = findViewById(R.id.btn_selesai);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}