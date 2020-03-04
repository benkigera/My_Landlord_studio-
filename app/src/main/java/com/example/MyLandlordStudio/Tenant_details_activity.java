package com.example.MyLandlordStudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Tenant_details_activity extends AppCompatActivity {

    private Toolbar add_tenants_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_details_activity);

        TextInputEditText current_date=findViewById(R.id.current_date);

        //create a date string.
        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        current_date.setText(date_n);

        add_tenants_toolbar=findViewById(R.id.add_tenants_toolbar);
        setSupportActionBar(add_tenants_toolbar);
        add_tenants_toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tenant_details_menu,menu);
        return true;

    }
}
