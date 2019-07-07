package com.sda.travel_agency.component;

import com.sda.travel_agency.entity.*;
import com.sda.travel_agency.model.StarRating;
import com.sda.travel_agency.repository.AirportRepository;
import com.sda.travel_agency.repository.CityRepository;
import com.sda.travel_agency.repository.CountryRepository;
import com.sda.travel_agency.repository.HotelRepisitory;
import com.sda.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InitialDataInitializer implements
        ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private HotelRepisitory hotelRepisitory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        addCountry("Polska", Continent.EUROPE);
        addCountry("Mozambik", Continent.AFRICA);
        addCountry("Mexico", Continent.NORTH_AMERICA);
        addCountry("Germany", Continent.EUROPE);

        addCity("Gdańsk", "Polska");
        addAirport("Walesa", "Gdańsk");
        addHotel("Mariot", "Gdańsk", StarRating.THREE, "Ładny");
        addHotel("Cubus", "Gdańsk", StarRating.FOUR, "Nie urzeka");

        addCity("Borkowo", "Polska");
        addAirport("AirBorkowo", "Borkowo");

        addCity("Włocławek", "Polska");

        addCity("Ugutulu", "Mozambik");
        addAirport("UguAirport", "Ugutulu");


        addCity("BugaBuga", "Mozambik");
        addAirport("Buga Airport", "BugaBuga");
        addHotel("ExHut", "Mozambik", StarRating.FIVE, "Luksusowy");

        addCity("HolaHO", "Mozambik");
        addAirport("Ho Airport", "HolaHO");

    }

    private void addCountry(String country, Continent continent) {
        if(!countryRepository.existsByCountryName(country)){
            countryRepository.save(new Country(country, continent));
        }
    }

    private void addCity(String city, String countryName) {
        if(!cityRepository.existsByCityName(city) && countryRepository.existsByCountryName(countryName)){
            Country country = countryRepository.findByCountryName(countryName);
            cityRepository.save(new City(city, country));
        }
    }


    private void addAirport(String airportName, String cityName) {
        if(!airportRepository.existsByAirportName(airportName) && cityRepository.existsByCityName(cityName)){
            City city = cityRepository.findByCityName(cityName);
            airportRepository.save(new Airport(airportName, city));
        }
    }

    private void addHotel(String hotelName, String cityName, StarRating starRating, String description) {
        if(!hotelRepisitory.existsByHotelName(hotelName) && cityRepository.existsByCityName(cityName)){
            City city = cityRepository.findByCityName(cityName);
            hotelRepisitory.save(new Hotel (hotelName, starRating, description, city));
        }
    }


}