package com.sda.travel_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

  //  @ManyToOne (fetch = FetchType.LAZY)
  //  @Enumerated(EnumType.STRING)
    private Continent continent;
}
