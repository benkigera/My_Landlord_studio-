package com.example.MyLandlordStudio;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class PaymentActivity extends AppCompatActivity {







    Toolbar add_payment_toolbar;
    MaterialCardView property_cardview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        //toolbar design

        add_payment_toolbar = findViewById(R.id.add_payment_toolbar);
        setSupportActionBar(add_payment_toolbar);
        add_payment_toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setTitle("Record payment");


        //Implementing on click on CardView

        property_cardview=findViewById(R.id.property_cardview);
        property_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent=new Intent(PaymentActivity.this,UnitListPaymentRecord.class);
              startActivity(intent);
            }
        });


    }





}
