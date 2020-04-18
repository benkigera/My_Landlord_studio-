package com.example.MyLandlordStudio;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class PropertyActivity extends AppCompatActivity {

    private ViewPager mSlidePlayer;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private TextView address,description,confirm;
    private MaterialButton button;
    private ProgressBar progressBar;
    private TableLayout table_view;

    //Property fields

    private TextInputEditText Location;
    private TextInputEditText Surbab;
    private TextInputEditText City;
    private TextInputEditText Country;
    private TextInputEditText name;
    private TextInputEditText valuation;
    private TextInputEditText type;
    private TextInputEditText number_of_units;
    private Property propertyObject;

    //Firebase
    FirebaseFirestore db;










    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);


     propertyObject=new Property();











        mSlidePlayer=findViewById(R.id.mSlideViewPager);
        mDotLayout=findViewById(R.id.mDotLayout);

        sliderAdapter=new SliderAdapter(this);
        mSlidePlayer.setAdapter(sliderAdapter);

        //adding a zoom out animation between sliders
        mSlidePlayer.setPageTransformer(true, new ZoomOutPageTransformer());
        button=findViewById(R.id.button_next);

        //textView
        address=findViewById(R.id.address);
        description=findViewById(R.id.description);
        confirm=findViewById(R.id.confirm);
        progressBar=findViewById(R.id.progressBar2);

        mSlidePlayer.setOffscreenPageLimit(6);











        addDotsIndicator(0);
        mSlidePlayer.addOnPageChangeListener(viewListener);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               jumpToPage(view);
            }
        });






    }

    public void jumpToPage(View view) {

        mSlidePlayer.setCurrentItem(mSlidePlayer.getCurrentItem() + 1, true);
    }

    public  void addDotsIndicator(int position){
        mDots=new TextView[3];
        mDotLayout.removeAllViews();

        for (int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8228;"));
            mDots[i].setTextSize(50);
            mDots[i].setTextColor(getResources().getColor(R.color.gray));

            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length>0){
           mDots[position].setTextColor(getResources().getColor(R.color.holo_green));

        }


    }










    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

            if (position==0){

                button.setBackgroundColor(getResources().getColor(R.color.gray));
                button.setText("Next");
                progressBar.setProgress(0);


            }

            if (position==1){
                address.setText("✔");
                address.setBackgroundResource( R.drawable.circle_green_xml);
                progressBar.setProgress(50);
                button.setBackgroundColor(getResources().getColor(R.color.gray));
                button.setText("Next");
                button.setTextColor(getResources().getColor(R.color.black));



            }

            if (position==2){
                description.setText("✔");
                description.setBackgroundResource( R.drawable.circle_green_xml);
                progressBar.setProgress(100);
                button.setBackgroundColor(getResources().getColor(R.color.holo_green));
                button.setText("Add property");



                table_view=findViewById(R.id.imagecontainer);
                for(int i = 0; i < 5; i ++){
                    LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService
                            (Context.LAYOUT_INFLATER_SERVICE);
                    LinearLayout row = (LinearLayout) inflater.inflate(R.layout.custom_row_add_property,null);
                    table_view.addView(row,i);
                }

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(PropertyActivity.this, OnPropertyAddSuccess.class);
                        startActivity(intent);
                    }
                });

              /*  //initializing textInput fields find view by id for textInputEditText
                Location=findViewById(R.id.location);
                Surbab=findViewById(R.id.surbab);
                City=findViewById(R.id.city);
                Country=findViewById(R.id.country);
                name=findViewById(R.id.property_name);
                valuation=findViewById(R.id.valuation);
                type=findViewById(R.id.property_type);
                number_of_units=findViewById(R.id.number_of_units);

                //initialize database object

                db=FirebaseFirestore.getInstance();


                //Adding property details through onclick listener
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        confirm.setText("✔");
                        confirm.setBackgroundResource(R.drawable.circle_green_xml);
                        String location = Location.getText().toString().trim();
                        String surbab = Surbab.getText().toString().trim();
                        String city = City.getText().toString().trim();
                        String country = Country.getText().toString().trim();
                        String Name = name.getText().toString().trim();
                        Double Valuation = Double.valueOf(valuation.getText().toString().trim());
                        boolean Property_type = Boolean.parseBoolean(type.getText().toString().trim());
                        String No_of_units = number_of_units.getText().toString().trim();


                        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

                        if (!validateInputs(location, surbab, city, country, Name, String.valueOf(Valuation), No_of_units)) {

                            CollectionReference dbTenants = db.collection("Users");


                            Property property = new Property(
                                    location,
                                    surbab,
                                    city,
                                    country,
                                    Name,
                                    Valuation,
                                    Property_type,
                                    No_of_units

                            );
                            dbTenants.document(uid).collection("property").add(property)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Intent intent=new Intent(PropertyActivity.this, OnPropertyAddSuccess.class);
                                            startActivity(intent);
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(PropertyActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            });
                        }
                    }
                });*/

            }




        }

        @Override
        public void onPageScrollStateChanged(int state) {
            int lastIdx=mSlidePlayer.getChildCount();
            int curItem=mSlidePlayer.getCurrentItem();


        }
    };

    private boolean validateInputs(String location, String surbarb, String city, String country, String p_name, String P_valuation, String units){
        if (location.isEmpty()){
            Location.setError("Location is required");
            Location.requestFocus();
            return true;
        }
        if (surbarb.isEmpty()){
            Surbab.setError("Second name is required");
            Surbab.requestFocus();
            return true;
        }
        if (city.isEmpty()){
            City.setError("Phone Number is required");
            City.requestFocus();
            return true;
        }
        if (country.isEmpty()){
            Country.setError("House Number required");
            Country.requestFocus();
            return true;
        }
        if (p_name.isEmpty()){
            name.setError("National ID required");
            name.requestFocus();
            return true;
        }
        if (P_valuation.isEmpty()){
            valuation.setError("Contract Date required");
            valuation.requestFocus();
            return true;
        }
        if (units.isEmpty()){
            number_of_units.setError("Amount required");
            number_of_units.requestFocus();
            return true;
        }

        return false;
    }


}
