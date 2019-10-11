package com.sda.travel_agency.repository;

import com.sda.travel_agency.entity.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    boolean existsByCountryName(String countryName);

    List<Country> findByCountryNameContaining(String countryName);

    Country findByCountryName(String countryName);

//    List<Country> findAllById(Long id, Pageable pageable);

}
