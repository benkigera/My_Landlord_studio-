package com.example.MyLandlordStudio;

public class Unit {

    private String house_number;
    private String rent;
    private String type;
    private String floor;
    private String state;

    public Unit(){

    }

    public Unit(String house_number, String rent, String type, String floor, String state) {
        this.house_number = house_number;
        this.rent = rent;
        this.type = type;
        this.floor = floor;
        this.state = state;
    }


    //getters and setters


    public String getHouse_number() {
        return house_number;
    }

    public String getRent() {
        return rent;
    }

    public String getType() {
        return type;
    }

    public String getFloor() {
        return floor;
    }

    public String getState() {
        return state;
    }


    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setState(String state) {
        this.state = state;
    }
}
