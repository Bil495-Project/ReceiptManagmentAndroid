package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    EditText mail,password;
    Button buton, reg;
    private String user;
    private String pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        mAuth = FirebaseAuth.getInstance();
        buton = (Button) findViewById(R.id.login);
        mail = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        reg =(Button) findViewById((R.id.button));
        buton.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        String email = mail.getText().toString();
        final String parola = password.getText().toString();

        //Email girilmemiş ise kullanıcıyı uyarıyoruz.
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Lütfen emailinizi giriniz", Toast.LENGTH_SHORT).show();
            return;
        }
        //Parola girilmemiş ise kullanıcıyı uyarıyoruz.
        if (TextUtils.isEmpty(parola)) {
            Toast.makeText(getApplicationContext(), "Lütfen parolanızı giriniz", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, parola)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                           // Toast.makeText(getApplicationContext(), ":)))", Toast.LENGTH_SHORT).show();

                            setContentView(R.layout.homepage);
                        }
                        else {
                            Log.e("Giriş Hatası",task.getException().getMessage());
                        }
                    }
                });

    }
}
