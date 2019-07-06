package com.sda.travel_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    private LocalDate flyOut;

    private LocalDate flyBack;

    @Formula("(flyBack - flyOut)")
    private int numberOfDays;

    private String mealsType;

    private float adultPrice;

    private float childPrice;

    private boolean promoted;

    private int numberOfAdult;

}
