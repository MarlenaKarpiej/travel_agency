package com.sda.travel_agency.entity;

public enum Continent {

    ASIA("Asia"),
    AFRICA("Africa"),
    AUSTRALIA("Australia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America");


    private String name;

    Continent(String name) {

        this.name = name;
    }


    public String getName(){return name;}

}
