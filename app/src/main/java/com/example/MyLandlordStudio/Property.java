package com.example.MyLandlordStudio;

public class Property {
    private String Locaation;
    private String Surbab;
    private String City;
    private String Country;
    private String name;
    private Double valuation;
    private boolean type;
    private String number_of_units;

    public Property() {

    }

    public Property(String locaation, String surbab, String city, String country, String name, Double valuation, boolean type, String number_of_units) {
        Locaation = locaation;
        Surbab = surbab;
        City = city;
        Country = country;
        this.name = name;
        this.valuation = valuation;
        this.type = type;
        this.number_of_units = number_of_units;
    }

    public String getLocaation() {
        return Locaation;
    }

    public String getSurbab() {
        return Surbab;
    }

    public String getCity() {
        return City;
    }

    public String getCountry() {
        return Country;
    }

    public String getName() {
        return name;
    }

    public Double getValuation() {
        return valuation;
    }

    public boolean isType() {
        return type;
    }

    public String getNumber_of_units() {
        return number_of_units;
    }


    public void setLocaation(String locaation) {
        Locaation = locaation;
    }

    public void setSurbab(String surbab) {
        Surbab = surbab;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValuation(Double valuation) {
        this.valuation = valuation;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void setNumber_of_units(String number_of_units) {
        this.number_of_units = number_of_units;
    }
}

