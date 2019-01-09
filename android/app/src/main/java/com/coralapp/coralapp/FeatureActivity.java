package com.coralapp.coralapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class FeatureActivity extends AppCompatActivity {

    CardView diveCV, reportCV, historyCV;
    ImageView logoutIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature);

        diveCV = findViewById(R.id.cv_dive);
        reportCV = findViewById(R.id.cv_report);
        historyCV = findViewById(R.id.cv_history);

        logoutIV = findViewById(R.id.iv_logout);

        diveCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FeatureActivity.this, CoralMapsActivity.class));
            }
        });

        reportCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeatureActivity.this, ReportActivity.class));
            }
        });

        historyCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeatureActivity.this, HistoryActivity.class));
            }
        });

        logoutIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeatureActivity.this, MainActivity.class));
                finish();
                Toast.makeText(FeatureActivity.this, "LOGOUT SUCCESSFUL", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
