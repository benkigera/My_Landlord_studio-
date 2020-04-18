package com.example.MyLandlordStudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.MaskFilter;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.example.MyLandlordStudio.MaskWatcher.buildCpf;

public class Tenant_details_activity extends AppCompatActivity {

    private TextInputEditText first_name;
    private TextInputEditText second_name;
    private TextInputEditText phone_number;
    private TextInputEditText house_number;
    private TextInputEditText national_id;
    private TextInputEditText current_date;
    private TextInputEditText amount_paid;
    private TextInputEditText payment_for;
    private TextInputEditText email;



    private FirebaseFirestore db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_details_activity);


        db=FirebaseFirestore.getInstance();

        first_name=findViewById(R.id.first_name);
        second_name=findViewById(R.id.second_name);
        phone_number=findViewById(R.id.phone_number);
        house_number=findViewById(R.id.house_number);
        national_id=findViewById(R.id.national_id);
        current_date=findViewById(R.id.current_date);
        amount_paid=findViewById(R.id.amount_paid);
        payment_for=findViewById(R.id.payment_for);
        email=findViewById(R.id.email);
        Button outlinedButton = findViewById(R.id.outlinedButton);
        current_date=findViewById(R.id.current_date);



        //create a date string.
        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        current_date.setText(date_n);

        Toolbar add_tenants_toolbar = findViewById(R.id.add_tenants_toolbar);
        setSupportActionBar(add_tenants_toolbar);
        add_tenants_toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);


        //masking for national id

        national_id.addTextChangedListener( buildCpf());

        //set button click method

        outlinedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String First_Name=first_name.getText().toString().trim();
                String Second_Name=second_name.getText().toString().trim();
                String Phone_Number=phone_number.getText().toString().trim();
                String House_Number=house_number.getText().toString().trim();
                String National_ID=national_id.getText().toString().trim();
                String Contract_Date=current_date.getText().toString().trim();
                String Amount_Paid=amount_paid.getText().toString().trim();
                String Payment_For=payment_for.getText().toString().trim();
                String Email=email.getText().toString().trim();

                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

                if (!validateInputs(First_Name,Second_Name,Phone_Number,House_Number,National_ID,Contract_Date,Amount_Paid,Payment_For,Email)){

                    CollectionReference dbTenants=db.collection("Users");



                    Tenant tenant=new Tenant(
                            First_Name,
                            Second_Name,
                            Phone_Number,
                            House_Number,
                            National_ID,
                            Contract_Date,
                            Amount_Paid,
                            Payment_For,
                            Email
                    );
                    dbTenants.document(uid).collection("tenants").add(tenant)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(Tenant_details_activity.this,"Tenant Added",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Tenant_details_activity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });


    }
    private boolean validateInputs(String fname, String sname, String phoneNumber, String houseNumber, String national_ID, String contractDate, String amountPaid, String paymentFor, String Email){
        if (fname.isEmpty()){
            first_name.setError("Name required");
            first_name.requestFocus();
            return true;
        }
        if (sname.isEmpty()){
            second_name.setError("Second name is required");
            second_name.requestFocus();
            return true;
        }
        if (phoneNumber.isEmpty()){
            phone_number.setError("Phone Number is required");
            phone_number.requestFocus();
            return true;
        }
        if (houseNumber.isEmpty()){
            house_number.setError("House Number required");
            house_number.requestFocus();
            return true;
        }
        if (national_ID.isEmpty()){
            national_id.setError("National ID required");
            national_id.requestFocus();
            return true;
        }
        if (contractDate.isEmpty()){
            current_date.setError("Contract Date required");
            house_number.requestFocus();
            return true;
        }
        if (amountPaid.isEmpty()){
            amount_paid.setError("Amount required");
            amount_paid.requestFocus();
            return true;
        }
        if (paymentFor.isEmpty()){
            payment_for.setError("Type required");
            payment_for.requestFocus();
            return true;
        }
        if (Email.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return true;
        }
        return false;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tenant_details_menu,menu);
        return true;

    }


}
