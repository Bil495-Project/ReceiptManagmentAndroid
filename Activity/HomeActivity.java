package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Constants;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button yenifatura;
    Button faturalarim;
    Button bAyarlar;
    Button cikis;
    String app_server_url = "http://";
    ListView fisListesi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        yenifatura = (Button) findViewById(R.id.bFisEkle);
        bAyarlar = (Button) findViewById(R.id.bAyarlar);
        cikis = (Button) findViewById(R.id.bCikis);
        faturalarim = (Button) findViewById(R.id.bFislerim);
        yenifatura.setOnClickListener(this);
        fisListesi = (ListView) findViewById(R.id.fisListesi);
        bAyarlar.setOnClickListener(this);
        faturalarim.setOnClickListener(this);
        cikis.setOnClickListener(this);


        /*
        databaseReference=FirebaseDatabase.getInstance().getReference("receipts");
        faturalistesi=(ListView)findViewById((R.id.fisListesi));
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        faturalistesi.setAdapter(arrayAdapter);*/

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("receipts");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Log.w("", "Failed to read value.", databaseError.toException());

            }
        });


    }



    ArrayAdapter adapter;
    ArrayList<String> array  = new ArrayList<>();

    private void showData(DataSnapshot dataSnapshot) {

        int i=1;

        for(DataSnapshot ds : dataSnapshot.getChildren()){
            ReceiptModel uInfo = new ReceiptModel();
            uInfo.setReceipt_owner(ds.child("receipt_owner").getValue(String.class));
            uInfo.setLocation(ds.child("location").getValue(String.class));
            uInfo.setTax(ds.child("tax").getValue(String.class));
           uInfo.setTotalcost(ds.child("totalcost").getValue(String.class));

            //display all the information
            Log.d("database", "showData: name: " + uInfo.getReceipt_owner().toString());
            Log.d("database", "showData: location: " + uInfo.getLocation().toString());


            array.add("Fatura "+i+":\n");
            array.add("Fatura Sahibi: "+uInfo.getReceipt_owner());
            array.add("Faturanın yeri: "+uInfo.getLocation());
            array.add("Fatura tutarı: "+uInfo.getTotalcost()+"");
            array.add("Faturanın vergisi: "+uInfo.getTaxtax()+"");

            i++;


        }
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);

        fisListesi.setAdapter(adapter);

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















/*
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    ValueEventListener eventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                String Image = ds.child("receipt_owner").getValue(String.class);
                String Link = ds.child("location").getValue(String.class);
                String Title = ds.child("tax").getValue(String.class);
                int Views = ds.child("totalcost").getValue(Integer.class);
                Log.d("TAG", Image + "/" + Link + "/" + Title + "/" + Views);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Log.w("TAG", "Failed to read value.", databaseError.toException());
        }
    };*/
//moviesRef.addListenerForSingleValueEvent(eventListener);
}