package com.example.schoolcom.logindemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class RegisterActivity extends AppCompatActivity {

    EditText firstname, lastname, username, password;
    Button registerbtn;
    String http = "http://127.0.0.1/logindemo/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstname = (EditText) findViewById(R.id.rgt_firstname);
        lastname = (EditText) findViewById(R.id.rgt_lastname);
        username = (EditText) findViewById(R.id.rgt_username);
        password = (EditText) findViewById(R.id.rgt_password);
        registerbtn = (Button) findViewById(R.id.rgt_button);
    }
    public Void register(View view) {
       new InsertIntoDb().execute();
        return null;
    }
    class InsertIntoDb extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            String fname = firstname.getText().toString();
            String lname = lastname.getText().toString();
            String uname = username.getText().toString();
            String pass = password.getText().toString();
            HttpURLConnection urlConnection = null;

            try {
                URL url = new URL(http);


                JSONObject json = new JSONObject();
                json.put("firstname",fname);
                json.put("lastname", lname);
                json.put("username",uname);
                json.put("password", pass);

                JSONArray jsonArray = new JSONArray();
                jsonArray.put(json);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(5000);
                urlConnection.setReadTimeout(1000);
                urlConnection.setRequestProperty("content-type", "application/json");
                urlConnection.setRequestMethod("POST");
                urlConnection.connect();
                OutputStream outputStream = urlConnection.getOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(outputStream);
                writer.write(URLEncoder.encode(jsonArray.toString(), "UTF-8"));
                writer.flush();
                writer.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}

