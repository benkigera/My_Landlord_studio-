package com.example.MyLandlordStudio;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ApplicationFrame extends AppCompatActivity {
    Fragment selectedFragment=null;
    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //getWindow().setStatusBarColor(Color.parseColor("#ffffff"));

        //bottom navigation bar code

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Dashboard_Fragment()).commit();

        //universal top navigation bar code for the whole app

        toolbar=findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();


    {Toast.makeText(getApplicationContext(),"See Your Messages",Toast.LENGTH_SHORT).show();}

        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {




                        switch (item.getItemId()){

                            case R.id.Dashboard:
                                selectedFragment=new Dashboard_Fragment();
                                item.setChecked(true);

                                break;

                            case R.id.Reports:
                                selectedFragment=new Reports_Fragment();
                                item.setChecked(true);

                                break;
                            case R.id.Tenants:
                                selectedFragment=new Tenants_Fragment();
                                item.setChecked(true);

                                break;
                            case R.id.More:
                                selectedFragment=new Properties_Fragment();
                                item.setChecked(true);

                                break;



                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                        return true;

                    }
                };






            }


