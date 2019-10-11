package com.sda.travel_agency.repository;

import com.sda.travel_agency.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

 //   List<Trip> findAllById(Long id, Pageable pageable);
}
