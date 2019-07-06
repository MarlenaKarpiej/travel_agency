package com.sda.travel_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TripParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private TripPurchase tripPurchase;

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private int adultSeatsBought;
    private int childSeatsBought;


}
