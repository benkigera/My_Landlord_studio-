package com.example.MyLandlordStudio;

public class Property {
    private String location;
    private String surbab;
    private String city;
    private String country;
    private String name;
    private Double valuation;
    private boolean type;
    private String number_of_units;

    public Property() {

    }

    public Property(String location, String surbab, String city, String country, String name, Double valuation, boolean type, String number_of_units) {
        this.location = location;
        this.surbab = surbab;
        this.city = city;
        this.country = country;
        this.name = name;
        this.valuation = valuation;
        this.type = type;
        this.number_of_units = number_of_units;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSurbab() {
        return surbab;
    }

    public void setSurbab(String surbab) {
        this.surbab = surbab;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValuation() {
        return valuation;
    }

    public void setValuation(Double valuation) {
        this.valuation = valuation;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getNumber_of_units() {
        return number_of_units;
    }

    public void setNumber_of_units(String number_of_units) {
        this.number_of_units = number_of_units;
    }
}

