package com;

public class PropertyModel {

    private  String name;
    private String location;
    private long price;
    private String units;

    public PropertyModel(){}

    public PropertyModel(String Name, String Location, long price, String units) {
        this.name = Name;
        this.location = Location;
        this.price = price;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String Location) { this.location = location; }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
