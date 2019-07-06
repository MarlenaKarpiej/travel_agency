package com.sda.travel_agency.repository;

import com.sda.travel_agency.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByCityNameContaining(String cityName);
    boolean existsByCityName(String cityName);

    City findByCityName(String cityName);

}
