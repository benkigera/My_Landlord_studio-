package com.example.MyLandlordStudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PaymentActivity extends AppCompatActivity {

//    String payee;
//    Double amount;
//    String[] typeArray = new String[]{"Deposit", "Rent", "Water", "All", "Electricity"};

    private TextInputEditText textIputLayout_propertyName;
    private TextInputEditText textInputLayout_Unit;
    private TextInputEditText textInputLayout_unitRent;
    private TextInputEditText water_bill;
    private TextInputEditText garbage;
    private TextInputEditText excess_paid;
    private TextInputEditText current_date;
    private TextInputEditText textIputLayout_month;

    private FirebaseFirestore db;

    //TextInputLayout textInputLayout_houseNumber, Layout_date;
    Toolbar add_payment_toolbar;
    //final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        db=FirebaseFirestore.getInstance();

        textIputLayout_propertyName=findViewById(R.id.textIputLayout_propertyName);
        textInputLayout_Unit=findViewById(R.id.houseNumber);
        textInputLayout_unitRent=findViewById(R.id.rent);
        water_bill=findViewById(R.id.water_bill);
        garbage=findViewById(R.id.garbage);
        excess_paid=findViewById(R.id.excess_paid);
        current_date=findViewById(R.id.payment_date);
        textIputLayout_month=findViewById(R.id.textIputLayout_month);


        Button outlinedButton = findViewById(R.id.outlinedButton_addPayment);

        outlinedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Propery_Name=textIputLayout_propertyName.getText().toString().trim();
                String House_Number=textInputLayout_Unit.getText().toString().trim();
                String Monthly_Rent=textInputLayout_unitRent.getText().toString().trim();
                String Water_bill =water_bill.getText().toString().trim();
                String Extra_Money=excess_paid.getText().toString().trim();
                String Garbage=garbage.getText().toString().trim();
                String Date_Paid=current_date.getText().toString().trim();
                String Rent_for_the_month_of=textIputLayout_month.getText().toString().trim();


                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

                if (!validateInputs(Propery_Name,House_Number,Monthly_Rent,Water_bill,Garbage,Extra_Money,Date_Paid,Rent_for_the_month_of)){

                    CollectionReference dbTenants=db.collection("Users");



                    Rent_Payment rent_payment=new Rent_Payment(
                            Propery_Name,
                            House_Number,
                            Monthly_Rent,
                            Water_bill,
                            Garbage,
                            Extra_Money,
                            Date_Paid,
                            Rent_for_the_month_of
                    );
                    dbTenants.document(uid).collection("payment").add(rent_payment)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(PaymentActivity.this,"Payment Added",Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(PaymentActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });


        add_payment_toolbar = findViewById(R.id.add_payment_toolbar);
        setSupportActionBar(add_payment_toolbar);
        add_payment_toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
       // current_date=findViewById(R.id.current_date);

//         Layout_date= findViewById(R.id.Layout_date);
//
//        //House Number icon action onClick
//        textInputLayout_houseNumber = findViewById(R.id.textInputLayout_houseNumber);
//
//        textInputLayout_houseNumber.setEndIconOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textInputLayout_houseNumber.setEndIconDrawable(R.drawable.ic_person_black_24dp);
//            }
//        });
//
//         Layout_date.setEndIconOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                new DatePickerDialog(PaymentActivity.this, date, myCalendar
//                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//
//            }
//        });

    }

    private boolean validateInputs(String propery_Name, String month, String Hnumber, String rent, String waterB, String Gar, String Excess, String date_paid){
        if (propery_Name.isEmpty()){
            textIputLayout_propertyName.setError("Name required");
            textIputLayout_propertyName.requestFocus();
            return true;
        }
        if (Hnumber.isEmpty()){
            textInputLayout_Unit.setError("House Number required");
            textInputLayout_Unit.requestFocus();
            return true;
        }
        if (rent.isEmpty()){
            textInputLayout_unitRent.setError("Input rent");
            textInputLayout_unitRent.requestFocus();
            return true;
        }
        if (waterB.isEmpty()){
            water_bill.setError("waterbill");
            water_bill.requestFocus();
            return true;
        }
        if (Gar.isEmpty()){
            garbage.setError("Garbage required");
            garbage.requestFocus();
            return true;
        }
        if (Excess.isEmpty()){
            excess_paid.setError("Input 0 if empty");
            excess_paid.requestFocus();
            return true;
        }
        if (date_paid.isEmpty()){
            current_date.setError("Input date");
            current_date.requestFocus();
            return true;
        }
        if (month.isEmpty()){
            textIputLayout_month.setError("Month required");
            textIputLayout_month.requestFocus();
            return true;
        }

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_payments_menu, menu);
        return true;
    }

//    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
//
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear,
//                              int dayOfMonth) {
//
//            myCalendar.set(Calendar.YEAR, year);
//            myCalendar.set(Calendar.MONTH, monthOfYear);
//            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//            updateLabel();
//
//        }
//    };
//
//    private void updateLabel() {
//        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
//        current_date.setText(date_n);
//    }
}
