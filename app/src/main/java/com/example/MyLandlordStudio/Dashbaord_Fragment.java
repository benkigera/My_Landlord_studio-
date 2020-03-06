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


public class Dashbaord_Fragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        //to use find View by id use container
        View view=inflater.inflate(R.layout.fragment_dashboard,container,false);
        CardView add_payment_cardview = view.findViewById(R.id.add_payment_cardview);


        add_payment_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent from fragment to activity
                Intent paymentActivityIntent=new Intent(getActivity(),Payment.class);
                startActivity(paymentActivityIntent);

            }
        });
        return view;





    }
}
