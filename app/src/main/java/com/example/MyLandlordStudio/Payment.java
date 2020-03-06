package com.example.MyLandlordStudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Payment extends AppCompatActivity {

    String payee;
    Double amount;
    String[] typeArray = new String[]{"Deposit", "Rent", "Water", "All", "Electricity"};
    TextInputLayout textInputLayout_houseNumber, textInputLayout_date;
    Toolbar add_payment_toolbar;
    final Calendar myCalendar = Calendar.getInstance();
    TextInputEditText current_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        add_payment_toolbar = findViewById(R.id.add_payment_toolbar);
        setSupportActionBar(add_payment_toolbar);
        add_payment_toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        current_date=findViewById(R.id.current_date);

        textInputLayout_date = findViewById(R.id.textInputLayout_date);

        //House Number icon action onClick
        textInputLayout_houseNumber = findViewById(R.id.textIputLayout_houseNumber);

        textInputLayout_houseNumber.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textInputLayout_houseNumber.setEndIconDrawable(R.drawable.ic_person_black_24dp);
            }
        });

        textInputLayout_date.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(Payment.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_payments_menu, menu);
        return true;
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();

        }
    };

    private void updateLabel() {
        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        current_date.setText(date_n);
    }
}
