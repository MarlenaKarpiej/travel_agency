package com.sda.travel_agency.repository;

import com.sda.travel_agency.entity.TripPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripPurchaseRepository extends JpaRepository<TripPurchase, Long> {
}
