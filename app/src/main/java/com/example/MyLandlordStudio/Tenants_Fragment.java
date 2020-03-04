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

public class Tenants_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //to use find View by id use container
        View view=inflater.inflate(R.layout.fragment_tenants,container,false);
        CardView add_tenants_cardview = view.findViewById(R.id.add_tenants_cardview);


        add_tenants_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent from fragment to activity
                Intent tenant_detail=new Intent(getActivity(),Tenant_details_activity.class);
                startActivity(tenant_detail);

            }
        });
        return view;
    }
}
