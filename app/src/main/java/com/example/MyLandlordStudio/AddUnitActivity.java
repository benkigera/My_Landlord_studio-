package com.example.MyLandlordStudio;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Type;

public class AddUnitActivity extends AppCompatActivity {

    Toolbar toolbar;
    ExtendedFloatingActionButton extendedFloatingActionButton;

    AutoCompleteTextView type;
    TextInputEditText house_number;
    AutoCompleteTextView floor;
    AutoCompleteTextView occupancy;
    TextInputEditText rent;

    FirebaseFirestore db;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);



        extendedFloatingActionButton=findViewById(R.id.floating_action_button);


        //initializing textInput fields find view by id for textInputEditText
        type=findViewById(R.id.unit_type_dropdown);
        house_number=findViewById(R.id.dropdown_house_number);
        floor=findViewById(R.id.floor_exposed_menu);
        occupancy=findViewById(R.id.occupancy_exposed_dropdown);
        rent=findViewById(R.id.unit_rent);

        db=FirebaseFirestore.getInstance();

        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Type=type.getText().toString().trim();
                String House_Number=house_number.getText().toString().trim();
                String Floor=floor.getText().toString().trim();
                String Occupancy=occupancy.getText().toString().trim();
                String Rent=rent.getText().toString().trim();

                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

                if (!validateInputs(Type,House_Number,Floor,Occupancy,Rent)) {

                    CollectionReference dbTenants = db.collection("Users");


                    Unit unit = new Unit(
                         Type,House_Number,Floor,Occupancy,Rent

                    );
                    dbTenants.document(uid).collection("unit").add(unit)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(AddUnitActivity.this,"success",Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddUnitActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });

        getWindow().setStatusBarColor(Color.parseColor("#D81B60"));



        toolbar=findViewById(R.id.add_unit_toolbar);
        toolbar.setTitle("");

        final String[] type = new String[] {"single room", "bedsitter", "1- bedroom", "2- bedroom","3- bedroom"};


        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        R.layout.dropdown_menu_popup_item,
                        type);

        AutoCompleteTextView editTextFilledExposedDropdown =
                findViewById(R.id.unit_type_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);


        //Occupancy exposed menu

        String[] occupancy=new String[]{"Occupied","Vacant","Booked"};

        ArrayAdapter<String> adapter1 =

                new ArrayAdapter<>(
                        this,
                        R.layout.dropdown_menu_popup_item,
                        occupancy);

        AutoCompleteTextView occupancy_exposed_dropdown =
                findViewById(R.id.occupancy_exposed_dropdown);
        occupancy_exposed_dropdown.setAdapter(adapter1);


        //Occupancy exposed menu

        String [] floor=new String[] {"basement","Ground","1st","2nd","3rd","4th","5th","6th","7th"};
        ArrayAdapter<String> adapter2=
                new ArrayAdapter<>(
                        this,
                        R.layout.dropdown_menu_popup_item,
                        floor);

        AutoCompleteTextView floor_exposed_menu=
                findViewById(R.id.floor_exposed_menu);
        floor_exposed_menu.setAdapter(adapter2);

    }

    private boolean validateInputs(String Type, String H_number, String Floor, String Occupancy, String Rent) {
        if (Type.isEmpty()) {
            type.setError("Location is required");
            type.requestFocus();
            return true;
        }
        if (H_number.isEmpty()) {
            house_number.setError("Second name is required");
            house_number.requestFocus();
            return true;
        }
        if (Floor.isEmpty()) {
            floor.setError("Phone Number is required");
            floor.requestFocus();
            return true;
        }
        if (Occupancy.isEmpty()) {
            occupancy.setError("House Number required");
            occupancy.requestFocus();
            return true;
        }
        if (Rent.isEmpty()) {
            rent.setError("National ID required");
            rent.requestFocus();
            return true;
        }

        return false;

        }



    }


