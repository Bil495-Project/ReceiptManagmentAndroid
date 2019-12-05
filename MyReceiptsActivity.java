package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MyReceiptsActivity extends AppCompatActivity implements View.OnClickListener {

    ListView FaturaFisListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faturalarim);

        FaturaFisListesi = (ListView) findViewById(R.id.FaturaFisListesi);

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


            Log.d("database", "showData: kullanıcı: " + LoginActivity.kullanici.toString());

            if((uInfo.getReceipt_owner().toString()).equals(LoginActivity.kullanici.toString())){
                Log.d("database", "showData: GİRDİ: " + uInfo.getLocation().toString());

                array.add("Fatura "+i+":\n");
                array.add("Faturanın yeri: "+uInfo.getLocation());
                array.add("Fatura tutarı: "+uInfo.getTotalcost()+"");
                array.add("Faturanın vergisi: "+uInfo.getTaxtax()+"");

            i++;}


        }
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);

        FaturaFisListesi.setAdapter(adapter);

    }
    @Override
    public void onClick(View v) {

    }
}
