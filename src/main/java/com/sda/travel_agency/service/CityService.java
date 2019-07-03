package com.sda.travel_agency.service;


import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryService countryService;

    public Iterable<City>  getAllCity(){
        return cityRepository.findAll();
    }

    public void createOrUpdateCityForCountry(City city, Long countryId){
        Optional<Country> country = countryService.findCountryById(countryId);
        country.ifPresent(city::setCountry);
        cityRepository.save(city);
    }

    public List<City> findAllByCityNameContaining(String cityName){
        return cityRepository.findByCityNameContaining(cityName);
    }

    public void deleteById (Long cityId){
        cityRepository.deleteById(cityId);
    }

    public Optional<City> findCityById(Long cityId) {
        return cityRepository.findById(cityId);
    }

}
