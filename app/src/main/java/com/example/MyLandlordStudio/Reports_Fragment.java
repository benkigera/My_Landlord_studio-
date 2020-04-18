package com.example.MyLandlordStudio;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.MyLandlordStudio.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class Reports_Fragment extends Fragment {

    private Toolbar toolbar_reports;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setHasOptionsMenu(true);



        //tabbed activity in reports fragment



        //to use find View by id use container
        View view=inflater.inflate(R.layout.fragment_reports,container,false);
        CardView monthly_reports_cardView = view.findViewById(R.id.monthly_reports_cardview);
        toolbar_reports=view.findViewById(R.id.toolbar_reports);
        toolbar_reports.inflateMenu(R.menu.refresh_menu);
        Menu menu=toolbar_reports.getMenu();

        monthly_reports_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent from fragment to activity
                Intent monthly_reports_intent=new Intent(getActivity(), Monthly_reports_view_activity.class);
                startActivity(monthly_reports_intent);

            }
        });

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }






}


