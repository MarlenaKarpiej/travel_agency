package com.sda.travel_agency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER)
    private Bill bill;

    private int adultSeats;
    private int childSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;

    public double calculatePrice() {
        return (adultSeats * trip.getAdultPrice()) + (childSeats * trip.getChildPrice());
    }
}
