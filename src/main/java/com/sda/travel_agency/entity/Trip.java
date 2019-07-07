package com.sda.travel_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @NotNull
    private Airport fromAirport;

    @OneToOne(fetch = FetchType.LAZY)
    @NotNull
    private Airport toAirport;

    @OneToOne(fetch = FetchType.LAZY)
    @NotNull
    private Hotel hotel;

    @Column(name = "fly_out")
    private LocalDate flyOut;

    @Column(name = "fly_back")
    private LocalDate flyBack;

    @Formula("(fly_back - fly_out)")
    private int numberOfDays;

    private String mealsType;

    private float adultPrice;

    private float childPrice;

    private boolean promoted;

    private int seatsNumber;


    @OneToMany(fetch = FetchType.LAZY)
    private List<TripPurchase> tripPurchases;
}
