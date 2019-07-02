package com.sda.travel_agency.entity;

public enum Continent {

    ASIA(0),
    AFRICA(1),
    AUSTRALIA(2),
    EUROPE(3),
    NORTH_AMERICA(4),
    SOUTH_AMERICA(5);

    private int continent;

    Continent(int continent) {
        this.continent = continent;
    }

    public int getContinent() {
        return continent;
    }

}
