package com.sda.travel_agency.service;


import com.sda.travel_agency.entity.TripPurchase;
import com.sda.travel_agency.repository.TripPurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripPurchaseService {

    private final TripPurchaseRepository tripPurchaseRepository;


    private void create (TripPurchase tripPurchase){
        tripPurchaseRepository.save(tripPurchase);
    }

}
