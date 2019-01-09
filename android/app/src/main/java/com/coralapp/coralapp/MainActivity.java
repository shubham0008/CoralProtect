package com.coralapp.coralapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailET;
    EditText passwordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET = (EditText)  findViewById(R.id.username);
        passwordET = (EditText)  findViewById(R.id.password);

        emailET.setText("sk");
        passwordET.setText("sk");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailET.getText().toString().equals("sk") && passwordET.getText().toString().equals("sk")){
                    startActivity(new Intent(MainActivity.this, FeatureActivity.class));
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Incorrect Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
