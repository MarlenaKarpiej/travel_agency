package com.sda.travel_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //musieliśmy dopisać strategy, ponieważ dodaliśmy już kilku włascicieli w data.sql
    private Long id;

    private String countryName;

    @Enumerated(EnumType.STRING)
    private Continent continent;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;

}
