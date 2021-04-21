package com.example.MyLandlordStudio;

public class Rent_Payment {

    private String Propery_Name,
            House_Number,
            Monthly_Rent,
            Water_bill,
            Extra_Money,
            Garbage,
            Date_Paid,
            Rent_for_the_month_of;

    public Rent_Payment(String propery_Name, String house_Number, String monthly_Rent, String water_bill, String extra_Money, String garbage, String date_Paid, String rent_for_the_month_of) {
        Propery_Name = propery_Name;
        House_Number = house_Number;
        Monthly_Rent = monthly_Rent;
        Water_bill = water_bill;
        Extra_Money = extra_Money;
        Garbage = garbage;
        Date_Paid = date_Paid;
        Rent_for_the_month_of = rent_for_the_month_of;
    }

    public String getPropery_Name() {
        return Propery_Name;
    }

    public void setPropery_Name(String propery_Name) {
        Propery_Name = propery_Name;
    }

    public String getHouse_Number() {
        return House_Number;
    }

    public void setHouse_Number(String house_Number) {
        House_Number = house_Number;
    }

    public String getMonthly_Rent() {
        return Monthly_Rent;
    }

    public void setMonthly_Rent(String monthly_Rent) {
        Monthly_Rent = monthly_Rent;
    }

    public String getWater_bill() {
        return Water_bill;
    }

    public void setWater_bill(String water_bill) {
        Water_bill = water_bill;
    }

    public String getExtra_Money() {
        return Extra_Money;
    }

    public void setExtra_Money(String extra_Money) {
        Extra_Money = extra_Money;
    }

    public String getGarbage() {
        return Garbage;
    }

    public void setGarbage(String garbage) {
        Garbage = garbage;
    }

    public String getDate_Paid() {
        return Date_Paid;
    }

    public void setDate_Paid(String date_Paid) {
        Date_Paid = date_Paid;
    }

    public String getRent_for_the_month_of() {
        return Rent_for_the_month_of;
    }

    public void setRent_for_the_month_of(String rent_for_the_month_of) {
        Rent_for_the_month_of = rent_for_the_month_of;
    }
}
