package com.sda.travel_agency.service;


import com.sda.travel_agency.entity.Purchase;
import com.sda.travel_agency.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;


    private void create (Purchase purchase){
        purchaseRepository.save(purchase);
    }


//    public float  calculatePrice(float adultPrice, float childPrice, int adultSeats, int childSeats){
//        price = adultPrice * adultSeats + childPrice * childSeats;
//        return price;
//    }

}
