package com.sda.travel_agency.dto;

import com.sda.travel_agency.model.MealsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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

    private MealsType mealsType;
    private float adultPrice;
    private float childPrice;
    private boolean promoted;
    private int seatsNumber;
}
