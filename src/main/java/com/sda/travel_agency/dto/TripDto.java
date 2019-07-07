package com.sda.travel_agency.dto;

import com.sda.travel_agency.entity.Airport;
import com.sda.travel_agency.entity.Hotel;
import com.sda.travel_agency.entity.TripPurchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate flyOut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate flyBack;

    private String mealsType;
    private float adultPrice;
    private float childPrice;
    private boolean promoted;
    private int seatsNumber;
}
