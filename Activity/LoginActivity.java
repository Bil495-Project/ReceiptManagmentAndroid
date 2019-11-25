package com.example.proje.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proje.ApiAuthentication;
import com.example.proje.HerokuService;
import com.example.proje.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mail,password;
    Button buton, reg;
    private String user;
    private String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);


        buton = (Button) findViewById(R.id.login);
        mail = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        reg =(Button) findViewById((R.id.button));
       // goToHomeActivity();
        buton.setOnClickListener(this);
        //reg.setOnClickListener(this);
    }


    private void goToHomeActivity() {
        Bundle bundle = new Bundle();
        bundle.putString("username", mail.getText().toString());
        bundle.putString("password", password.getText().toString());
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        goToHomeActivity();

    }

    protected class ExecuteNetworkOperation extends AsyncTask<Void, Void, String> {

        private ApiAuthentication apiAuthenticationClient;
        private String isValidCredentials;

        public ExecuteNetworkOperation(ApiAuthentication apiAuthenticationClient) {
            this.apiAuthenticationClient = apiAuthenticationClient;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
               // System.out.println(user+" ..");
                isValidCredentials = apiAuthenticationClient.executeForLogin();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Login Success
            if (isValidCredentials.contains("Success")) {
                goToHomeActivity();
            }
            // Login Failure
            else {
                Toast.makeText(getApplicationContext(), "Login Is Failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}
