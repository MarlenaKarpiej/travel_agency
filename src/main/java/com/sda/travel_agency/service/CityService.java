package com.sda.travel_agency.service;


import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryService countryService;

    public void createOrUpdateCityForCountry(City city, Long countryId){
        Optional<Country> country = countryService.findCountryById(countryId);
        country.ifPresent(city::setCountry);
        cityRepository.save(city);
    }

    public void deleteById (Long id){
        cityRepository.deleteById(id);
    }


    public Optional<City> getCityById(Long cityId) {
        return cityRepository.findById(cityId);
    }

}
