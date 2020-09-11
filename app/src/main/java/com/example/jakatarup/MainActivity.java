package com.example.jakatarup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jakatarup.Retrofit.ApiClient;
import com.example.jakatarup.Utils.Util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_info, btn_assessment, btn_pantau, btn_wa, btn_produk, btn_trolling, btn_user, btn_news;
    TextView txt_user;

    LinearLayout menu_assessent;
    Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_info = findViewById(R.id.btn_info);
        btn_assessment = findViewById(R.id.btn_assessment);
        btn_pantau = findViewById(R.id.btn_pantau);
        btn_wa = findViewById(R.id.btn_wa);
        btn_produk = findViewById(R.id.btn_produk);
        btn_trolling = findViewById(R.id.btn_trolling);
        btn_user = findViewById(R.id.btn_user);
        txt_user = findViewById(R.id.txt_user);
        btn_news = findViewById(R.id.btn_news);

        menu_assessent = findViewById(R.id.menu_assessment);

        btn_info.setOnClickListener(this);
        btn_assessment.setOnClickListener(this);
        btn_pantau.setOnClickListener(this);
        btn_wa.setOnClickListener(this);
        btn_produk.setOnClickListener(this);
        btn_trolling.setOnClickListener(this);
        btn_news.setOnClickListener(this);

        util = new Util(this);

        if (util.cekLogin()){
            txt_user.setText("Profil");
            btn_user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), ProfilActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            menu_assessent.setVisibility(View.VISIBLE);
        }else{
            txt_user.setText("Login");
            btn_user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            menu_assessent.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        Uri uri;
        switch(v.getId()){
            case R.id.btn_info:
//                intent = new Intent(this, NewsActivity.class);
                uri = Uri.parse("https://drive.google.com/file/d/1uXu4RJ2wNJkdwVnU-h2NG9Fmhhlkfhcm/view");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                this.startActivity(intent);
                break;
            case R.id.btn_news:
                uri = Uri.parse(ApiClient.URL);
                intent = new Intent(Intent.ACTION_VIEW, uri);
                this.startActivity(intent);
                break;
            case R.id.btn_produk:
                uri = Uri.parse("https://drive.google.com/file/d/15wxoy3UVXseAbHwa4ZDLbgecpH2Jflpk/view");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                this.startActivity(intent);
                break;
            case R.id.btn_assessment:
                intent = new Intent(this, AssessmentActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_wa:
                String contact = "+62 87766919070"; // use country code with your phone number
                String url = "https://api.whatsapp.com/send?phone=" + contact+"&text=Hello";
                try {
                    PackageManager pm=getPackageManager();
                    PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "WhatsApp belum di install", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            case R.id.btn_pantau:
                intent = new Intent(this, MaintanceActivity.class);
                intent.putExtra("keterangan", "Menu Pagar (Pantau Gerak) Dipersiapkan Untuk Pemantauan Pergerakan Kelompok Masa Berbasis CCTV");
                this.startActivity(intent);
                break;
            case R.id.btn_trolling:
                intent = new Intent(this, MaintanceActivity.class);
                intent.putExtra("keterangan", "Menu Trolling (Kontrol Keliling Petugas) Dipersiapkan Untuk Absensi Petugas Kontrol Berbasis Koordinat");
                this.startActivity(intent);
                break;
            default:
                break;
        }
    }
}