package com.sda.travel_agency.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;
    private int starRating;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    public Hotel(String hotelName, int starRating, String description, City city) {
        this.hotelName = hotelName;
        this.starRating = starRating;
        this.description = description;
        this.city = city;
    }
}
