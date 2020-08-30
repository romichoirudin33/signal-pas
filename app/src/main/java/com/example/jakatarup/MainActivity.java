package com.example.jakatarup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_info, btn_assessment, btn_pantau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_info = findViewById(R.id.btn_info);
        btn_assessment = findViewById(R.id.btn_assessment);
        btn_pantau = findViewById(R.id.btn_pantau);

        btn_info.setOnClickListener(this);
        btn_assessment.setOnClickListener(this);
        btn_pantau.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.btn_info:
                intent = new Intent(this, NewsActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_assessment:
                intent = new Intent(this, AssessmentActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_pantau:
                intent = new Intent(this, LoginActivity.class);
                this.startActivity(intent);
                break;
            default:
                break;
        }
    }
}