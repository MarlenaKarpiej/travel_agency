package com.sda.travel_agency.dto;

import com.sda.travel_agency.entity.Airport;
import com.sda.travel_agency.entity.Hotel;
import com.sda.travel_agency.entity.TripPurchase;
import lombok.AllArgsConstructor;
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
public class TripDto {

    private Long fromAirport;
    private Long toAirport;

    private Long hotel;

    private LocalDate flyOut;
    private LocalDate flyBack;

    private String mealsType;
    private float adultPrice;
    private float childPrice;
    private boolean promoted;
    private int seatsNumber;
}
