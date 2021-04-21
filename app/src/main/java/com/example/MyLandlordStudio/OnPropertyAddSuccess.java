package com.example.MyLandlordStudio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;

public class OnPropertyAddSuccess extends AppCompatActivity {


    private ImageView checkmark;
    private AnimatedVectorDrawableCompat avd;
    private AnimatedVectorDrawable avd2;
    Toolbar toolbar;
    Button button;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_property_add_success);

        getWindow().setStatusBarColor(Color.parseColor("#99cc00"));

     toolbar=findViewById(R.id.success_toolbar);
     button=findViewById(R.id.button_add_unit);
     checkmark=findViewById(R.id.checkmarkImage);

        Drawable drawable=checkmark.getDrawable();

        if (drawable instanceof AnimatedVectorDrawableCompat){
            avd=(AnimatedVectorDrawableCompat) drawable;
            avd.start();
        }else  if ( drawable instanceof  AnimatedVectorDrawable){
            avd2=(AnimatedVectorDrawable) drawable;
            avd2.start();
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OnPropertyAddSuccess.this, AddUnitActivity.class);
                startActivity(intent);
            }
        });


    }


}
