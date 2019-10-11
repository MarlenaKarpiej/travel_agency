package com.sda.travel_agency.model;

public enum MealsType {

    BB("Bed and breakfast"),
    HB("Half board"),
    FB("Full board"),
    ALL_INC("All inclusive");

    private String name;

    MealsType(String name) {

        this.name = name;
    }


    public String getName(){return name;}
}
