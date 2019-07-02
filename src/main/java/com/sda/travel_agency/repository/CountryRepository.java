package com.sda.travel_agency.repository;

import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByCountryNameContaining(String countryName);

}
