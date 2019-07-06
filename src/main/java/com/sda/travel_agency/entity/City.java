package com.sda.travel_agency.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String cityName;

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city")
    private List<Hotel> hotels;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private List<Airport> airports;

    public City(String cityName, Country country) {
        this.cityName = cityName;
        this.country = country;
    }
}
