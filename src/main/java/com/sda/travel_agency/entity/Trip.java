package com.sda.travel_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
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
    private Airport fromAirport;

    @OneToOne(fetch = FetchType.LAZY)
    private Airport toAirport;

//    private Hotel hotel;

    private LocalDate flyOut;

    private LocalDate flyBack;

    @Formula("(flyBack - flyOut)")
    private int numberOfDays;

    private String mealsType;

    private float adultPrice;

    private float childPrice;

    private boolean promoted;

    private int numberOfAdult;

    private int numberOfChildren;


    public int countingDays(LocalDate flyOut, LocalDate flyBack){
        numberOfDays = flyBack.getDayOfYear() - flyOut.getDayOfMonth();
        return numberOfDays;
    }


//    String startDate = "2016 01 02";
//    String passedDate = "2016 02 29";
//
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
//    LocalDate date1 = LocalDate.parse(startDate, formatter);
//    LocalDate date2 = LocalDate.parse(passedDate, formatter);
//
//    long elapsedDays = ChronoUnit.DAYS.between(date1, date2);
//System.out.println(elapsedDays); // 58 (correct)



}
