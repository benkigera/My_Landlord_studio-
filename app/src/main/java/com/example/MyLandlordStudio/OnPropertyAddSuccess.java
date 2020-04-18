package com.example.MyLandlordStudio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;

public class OnPropertyAddSuccess extends AppCompatActivity {


    ImageView checkmark;
    private AnimatedVectorDrawableCompat avd;
    private AnimatedVectorDrawable avd2;
    Toolbar toolbar;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_property_add_success);

     toolbar=findViewById(R.id.success_toolbar);


      /*  this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );*/

        checkmark=findViewById(R.id.checkmarkImage);

        Drawable drawable=checkmark.getDrawable();

        if (drawable instanceof AnimatedVectorDrawableCompat){
            avd=(AnimatedVectorDrawableCompat) drawable;
            avd.start();
        }else  if ( drawable instanceof  AnimatedVectorDrawable){
            avd2=(AnimatedVectorDrawable) drawable;
            avd2.start();
        }


    }


}
