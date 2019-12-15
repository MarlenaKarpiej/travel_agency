package com.sda.travel_agency.service;

import com.sda.travel_agency.entity.AppUser;
import com.sda.travel_agency.entity.Purchase;
import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.repository.AppUserRepository;
import com.sda.travel_agency.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final AppUserRepository appUserRepository;
    private final TripService tripService;


    public void create (Purchase purchase, Long tripId){
        Optional<Trip> trip = tripService.findTripById(tripId);
        trip.ifPresent(purchase::setTrip);
        purchaseRepository.save(purchase);
    }

    public void getUser (AppUser appUser){
        appUserRepository.findByEmail(appUser.getEmail());
    }

    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public Optional<Purchase> findPurchaseById(Long purchaseId) {
        return purchaseRepository.findById(purchaseId);
    }


//    public float  calculatePrice(float adultPrice, float childPrice, int adultSeats, int childSeats){
//        price = adultPrice * adultSeats + childPrice * childSeats;
//        return price;
//    }

}
