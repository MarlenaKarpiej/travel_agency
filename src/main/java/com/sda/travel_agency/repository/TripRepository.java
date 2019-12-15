package com.sda.travel_agency.repository;

import com.sda.travel_agency.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TripRepository extends JpaRepository<Trip, Long> {

    //   List<Trip> findAllById(Long id, Pageable pageable);

    @Query(value = "SELECT sum(p.adult_seats + p.child_seats) FROM purchase p join trip t on p.trip_id=t.id where trip_id = ?1", nativeQuery = true)
    Integer findHowManyPurchasesWereMade(Long tripId);
}
