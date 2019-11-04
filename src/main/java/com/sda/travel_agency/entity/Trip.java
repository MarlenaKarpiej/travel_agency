package com.sda.travel_agency.entity;

import com.sda.travel_agency.model.MealsType;
import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
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
    private Integer numberOfDays;

    private MealsType mealsType;

    private float adultPrice;

    private float childPrice;

    private boolean promoted;

    private int seatsNumber;


    @Lob
    @Column(nullable = true)
    private byte[] data;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
    private List<Purchase> purchases;

    @ManyToOne
    private Cart cart;

    public Trip(@NotNull Airport fromAirport,
                @NotNull Airport toAirport,
                @NotNull Hotel hotel,
                LocalDate flyOut,
                LocalDate flyBack,
                MealsType mealsType,
                float adultPrice,
                float childPrice,
                int seatsNumber,
                boolean promoted) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.hotel = hotel;
        this.flyOut = flyOut;
        this.flyBack = flyBack;
        this.numberOfDays = Period.between(flyOut, flyOut).getDays();
        this.mealsType = mealsType;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.promoted = promoted;
        this.seatsNumber = seatsNumber;
    }
}
