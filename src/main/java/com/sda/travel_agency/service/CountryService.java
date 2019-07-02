package com.sda.travel_agency.service;

import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public void createCountry(Country country){
        countryRepository.save(country);
    }

    public Iterable<Country>  getAllCountry(){
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryById(Long id){
        return countryRepository.findById(id);
    }

    public void editCountry (Country country){
        countryRepository.save(country);
    }

    public List<Country> findAllByCountryNameContaining(String countryName){
        return countryRepository.findByCountryNameContaining(countryName);
    }

    public void deleteById (Long id){
        countryRepository.deleteById(id);
    }

    public Optional<Country> findCountryById(Long countryId){
        return countryRepository.findById(countryId);
    }


}
