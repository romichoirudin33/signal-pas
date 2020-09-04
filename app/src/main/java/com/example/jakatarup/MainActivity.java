package com.example.jakatarup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_info, btn_assessment, btn_pantau, btn_wa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_info = findViewById(R.id.btn_info);
        btn_assessment = findViewById(R.id.btn_assessment);
        btn_pantau = findViewById(R.id.btn_pantau);
        btn_wa = findViewById(R.id.btn_wa);

        btn_info.setOnClickListener(this);
        btn_assessment.setOnClickListener(this);
        btn_pantau.setOnClickListener(this);
        btn_wa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.btn_info:
                intent = new Intent(this, MaintanceActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_assessment:
                intent = new Intent(this, LoginActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_pantau:
                intent = new Intent(this, MaintanceActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_wa:
                String contact = "+62 85253725455"; // use country code with your phone number
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
            default:
                break;
        }
    }
}