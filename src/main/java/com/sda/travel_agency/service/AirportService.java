package com.sda.travel_agency.service;

import com.sda.travel_agency.entity.Airport;
import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.entity.Hotel;
import com.sda.travel_agency.repository.AirportRepository;
import com.sda.travel_agency.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AirportService {

    private final AirportRepository airportRepository;
    private final CityService cityService;

    public void createOrUpdateAirportForCity(Airport airport, Long cityId) {

        Optional<City> city = cityService.findCityById(cityId);
            city.ifPresent(theCity -> airport.setCity(theCity));
            airportRepository.save(airport);
    }

    public Iterable<Airport> getAllAirport() {return airportRepository.findAll();}

    public List<Airport> findAllByAirportNameConatining(String airportName) {
        return airportRepository.findByAirportNameContaining(airportName);
    }

    public void deleteById (Long id) {airportRepository.deleteById(id);}

    public Optional<Airport> findAirportById (Long airportId) {return airportRepository.findById(airportId);}

    public List<Airport> findAirportByCity(City cityById) {
        return airportRepository.findByCity(cityById);
    }

    public List<Airport> findAllAirports() {
        return airportRepository.findAll();}
}
