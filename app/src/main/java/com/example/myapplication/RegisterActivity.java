package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class RegisterActivity extends AppCompatActivity {

    CardView cardview_next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_register);

        cardview_next= findViewById(R.id.cardview_next);

       cardview_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerNationalityIntent =new Intent(RegisterActivity.this,RegisterNationality.class);
                startActivity(registerNationalityIntent);
            }
        });


    }
}