package com.sda.travel_agency.repository;

import com.sda.travel_agency.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    boolean existsByCountryName(String cn);
    List<Country> findByCountryNameContaining(String countryName);
    Country findByCountryName(String countryName);

}
