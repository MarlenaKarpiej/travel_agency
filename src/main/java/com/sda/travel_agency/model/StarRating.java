package com.sda.travel_agency.model;

public enum StarRating {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5");

    private String number;

    StarRating(String number) {

        this.number = number;
    }


    public String getNumber(){return number;}
}
