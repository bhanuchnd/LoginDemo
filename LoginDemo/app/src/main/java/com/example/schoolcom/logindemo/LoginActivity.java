package com.example.schoolcom.logindemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.net.HttpURLConnection;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button loginBtn;
    TextView registerTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.lgn_username);
        password = (EditText) findViewById(R.id.lgn_password);
        loginBtn = (Button) findViewById(R.id.lgn_button);
        registerTxt = (TextView) findViewById(R.id.txt_register);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    public void registerHere(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

//    class Validate extends AsyncTask<Void,Void,Void> {
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            HttpURLConnection connection =  null;
//            BufferedReader reader;
//            String jsondata;
//
//            return null;
//        }
//    }
}
