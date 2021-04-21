package com.example.MyLandlordStudio;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;



public class Dashboard_Fragment extends Fragment {

    ExtendedFloatingActionButton floatingActionButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {





        //to use find View by id use container
       View view=inflater.inflate(R.layout.fragment_dashboard,container,false);
        CardView add_payment_cardview = view.findViewById(R.id.add_payment_cardview);


       // floating action to add property list


        floatingActionButton=view.findViewById(R.id.floating_action_button);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent propertyActivityIntent=new Intent(getActivity(), PropertyActivity.class);
                startActivity(propertyActivityIntent);
            }
        });


        add_payment_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent from fragment to activity
                Intent paymentActivityIntent=new Intent(getActivity(), PaymentActivity.class);
                startActivity(paymentActivityIntent);

            }
        });
      return view;}
}



