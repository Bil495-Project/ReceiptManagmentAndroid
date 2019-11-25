package com.example.proje.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proje.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button yenifatura;
    Button faturalarim;
    Button bAyarlar;
    Button cikis;
    String app_server_url = "http://";
    Button ayarlar;
    ListView faturalistesi;
    private String[] list;
    private ArrayAdapter adapter;
    ArrayList<String> aList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        yenifatura = (Button) findViewById(R.id.bFisEkle);
        bAyarlar = (Button) findViewById(R.id.bAyarlar);
        cikis = (Button) findViewById(R.id.bCikis);
        faturalarim = (Button) findViewById(R.id.bFislerim);
        yenifatura.setOnClickListener(this);
        bAyarlar.setOnClickListener(this);
        faturalarim.setOnClickListener(this);
        cikis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bFisEkle:
                startActivity(new Intent(this, ReceiptAddingActivity.class));
                break;
            case R.id.bFislerim:
                startActivity(new Intent(this, MyReceiptsActivity.class));
                break;
            case R.id.bAyarlar:
                startActivity(new Intent(this, MySettingActivity.class));
                break;
            case R.id.bCikis:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
