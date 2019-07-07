package com.sda.travel_agency.entity;


import lombok.*;

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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city")
    private List<Hotel> hotels;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private List<Airport> airports;

    public City(String cityName, Country country) {
        this.cityName = cityName;
        this.country = country;
    }
}
