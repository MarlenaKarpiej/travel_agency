package com.sda.travel_agency.repository;

import com.sda.travel_agency.entity.Airport;
import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByAirportNameContaining(String airportName);
    List<Airport> findByCity(City city);
    boolean existsByAirportName(String airportName);
    Airport findByAirportName(String airportName);


}

