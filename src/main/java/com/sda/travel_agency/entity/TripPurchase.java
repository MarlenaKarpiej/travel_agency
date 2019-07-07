package com.sda.travel_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TripPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TripParticipant> tripParticipantsList;


    private float price;


    public float  calculatePrice(float adultPrice, float childPrice, int adultSeatsBought, int childSeatsBought){
        price = adultPrice * adultSeatsBought + childPrice * childSeatsBought;
        return price;
    }
}
