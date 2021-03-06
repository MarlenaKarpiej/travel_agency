package com.sda.travel_agency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String countryName;

    @Enumerated(EnumType.STRING)
    private Continent continent;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")//, cascade = CascadeType.ALL) //jeżeli usuniesz cascade = CascadeType.ALL to usuwanie miast zacznie działać
    private List<City> cities;

    public Country(String countryName, Continent continent) {
        this.countryName = countryName;
        this.continent = continent;
    }
}
