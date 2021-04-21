package com.example.MyLandlordStudio;




public class Tenant {
    private String first_name,second_name,phone_number,house_number;
    private String national_id,contract_date,amount_paid,payment_for,email;


    public Tenant() {
    }

    public Tenant(String first_name, String second_name, String phone_number, String house_number, String national_id, String contract_date, String amount_paid, String payment_for, String email) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.phone_number = phone_number;
        this.house_number = house_number;
        this.national_id = national_id;
        this.contract_date = contract_date;
        this.amount_paid = amount_paid;
        this.payment_for = payment_for;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getHouse_number() {
        return house_number;
    }

    public String getNational_id() {
        return national_id;
    }

    public String getContract_date() {
        return contract_date;
    }

    public String getAmount_paid() {
        return amount_paid;
    }

    public String getPayment_for() {
        return payment_for;
    }

    public String getEmail() {
        return email;
    }
}
