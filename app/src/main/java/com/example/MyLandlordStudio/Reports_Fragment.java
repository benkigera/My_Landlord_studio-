package com.example.MyLandlordStudio;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;



public class Reports_Fragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //to use find View by id use container
        View view=inflater.inflate(R.layout.fragment_reports,container,false);
        CardView monthly_reports_cardView = view.findViewById(R.id.monthly_reports_cardview);


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


}
