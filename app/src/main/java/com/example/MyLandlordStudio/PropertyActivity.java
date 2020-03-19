package com.example.MyLandlordStudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PropertyActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        Button outlinedButton=findViewById(R.id.outlinedButton);
        outlinedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent propertyList=new Intent(PropertyActivity.this,PropertyListView.class);
                startActivity(propertyList);
            }
        });


    }
}
