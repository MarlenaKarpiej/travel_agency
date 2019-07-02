package com.sda.travel_agency.entity;

public enum Continent {

    ASIA(0, "Asia"),
    AFRICA(1, "Africa"),
    AUSTRALIA(2, "Australia"),
    EUROPE(3, "Europe"),
    NORTH_AMERICA(4, "North America"),
    SOUTH_AMERICA(5, "South America");

    private int value;
    private String name;

    Continent(int value, String name) {

        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName(){return name;}

}
