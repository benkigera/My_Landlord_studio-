package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare variables
    EditText editTextEmail,editTextPassword;
    CardView cardview_login;
    TextView textViewRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        editTextEmail =(EditText)findViewById(R.id.editTextEmail);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        cardview_login=(CardView)findViewById(R.id.cardview_login);
        textViewRegister=(TextView)findViewById(R.id.textViewRegister);

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent =new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        cardview_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dashboardIntent=new Intent(MainActivity.this,Dashbaord.class);
                startActivity(dashboardIntent);
            }
        });




    }
}
