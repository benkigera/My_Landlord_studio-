package com.example.MyLandlordStudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.MyLandlordStudio.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Tenants_Fragment extends Fragment {

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //to use find View by id use container
        View view=inflater.inflate(R.layout.fragment_tenants,container,false);


        //set up the viewPager with the sections adapter
        sectionsPagerAdapter=new SectionsPagerAdapter(getChildFragmentManager());
        viewPager=view.findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        TabLayout tabLayout=view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);



        tabLayout.setupWithViewPager(viewPager);


// tab layout  icons
        int[] icons = {
                R.drawable.ic_timeline_black_24dp,
                R.drawable.ic_timeline_black_24dp,
                R.drawable.ic_timeline_black_24dp
        };

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }






        return view;
    }




    private void setupViewPager(ViewPager viewPager){

        SectionsPagerAdapter adapter=new SectionsPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new Tab1Fragment(),"Past");
        adapter.addFragment(new Tab2Fragment(),"Current");
        adapter.addFragment(new Tab3Fragment(),"Prospects");

        viewPager.setAdapter(adapter);

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
