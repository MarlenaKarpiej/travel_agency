package com.sda.travel_agency.component;

import com.sda.travel_agency.entity.*;
import com.sda.travel_agency.model.MealsType;
import com.sda.travel_agency.model.StarRating;
import com.sda.travel_agency.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        addCountry("Polska", Continent.EUROPE);
        addCountry("Mozambik", Continent.AFRICA);
        addCountry("Mexico", Continent.NORTH_AMERICA);
        addCountry("Germany", Continent.EUROPE);
        addCountry("Italy", Continent.EUROPE);
        addCountry("Spain", Continent.EUROPE);
        addCountry("Iran", Continent.ASIA);

        addCity("Gdańsk", "Polska");
        addAirport("Walesa", "Gdańsk");
        addHotel("Mariot", "Gdańsk", StarRating.THREE, "Ładny");
        addHotel("Cubus", "Gdańsk", StarRating.FOUR, "Nie urzeka");

        addCity("Warszawa", "Polska");
        addAirport("Chopin", "Warszawa");
        addHotel("Polonia Palace", "Warszawa", StarRating.THREE, "Doskonała lokalizacja");
        addHotel("Metropol ", "Warszawa", StarRating.FOUR, "Urzeka");


        addCity("Włocławek", "Polska");

        addCity("Maputo", "Mozambik");
        addAirport("International Airport", "Maputo");


        addCity("BugaBuga", "Mozambik");
        addAirport("Buga Airport", "BugaBuga");
        addHotel("ExHut", "Mozambik", StarRating.FIVE, "Luksusowy");

        addCity("HolaHO", "Mozambik");
        addAirport("Ho Airport", "HolaHO");

//        addTrip("pierwsze lotnisko", 2019-07-16, "drugie lotnisko", 2019-07-23,
//                "nowy", 2500, 1000, MealsType.ALL_INC, 45, true);


        createRoleIfNotExist("ADMIN");
        createRoleIfNotExist("USER");

        createUserWithRoleIfNotExist("admin", "admin", "ADMIN", "USER");
        createUserWithRoleIfNotExist("user", "user", "USER");
    }

    private void addCountry(String country, Continent continent) {
        if (!countryRepository.existsByCountryName(country)) {
            countryRepository.save(new Country(country, continent));
        }
    }

    private void addCity(String city, String countryName) {
        if (!cityRepository.existsByCityName(city) && countryRepository.existsByCountryName(countryName)) {
            Country country = countryRepository.findByCountryName(countryName);
            cityRepository.save(new City(city, country));
        }
    }


    private void addAirport(String airportName, String cityName) {
        if (!airportRepository.existsByAirportName(airportName) && cityRepository.existsByCityName(cityName)) {
            City city = cityRepository.findByCityName(cityName);
            airportRepository.save(new Airport(airportName, city));
        }
    }

    private void addHotel(String hotelName, String cityName, StarRating starRating, String description) {
        if (!hotelRepisitory.existsByHotelName(hotelName) && cityRepository.existsByCityName(cityName)) {
            City city = cityRepository.findByCityName(cityName);
            hotelRepisitory.save(new Hotel(hotelName, starRating, description, city));
        }
    }

//TODO
    private void addTrip(String fromAirport, LocalDate flyOut, String toAirport, LocalDate flyBack,
                         String hotelName, float adultPrice, float childPrice, MealsType mealsType, int seatsNumber, boolean promoted) {

        Airport airportFrom = airportRepository.findByAirportName(fromAirport);
        Airport airportTo = airportRepository.findByAirportName(toAirport);
        Hotel hotel = hotelRepisitory.findByHotelName(hotelName);

        tripRepository.save(new Trip(airportFrom, flyOut, airportTo, flyBack, hotel, adultPrice, childPrice, mealsType, seatsNumber, promoted));
    }


    private void createUserWithRoleIfNotExist(String username, String password, String... roles) {
        if (!appUserRepository.existsByEmail(username)) {
            AppUser appUser = new AppUser();
            appUser.setEmail(username);
            appUser.setPassword(passwordEncoder.encode(password));

            appUser.setRoles(new HashSet<>(findRoles(roles)));

            appUserRepository.save(appUser);
        }
    }

    private List<UserRole> findRoles(String[] roles) {
        List<UserRole> userRoles = new ArrayList<>();

        for (String role : roles) {
            userRoles.add(userRoleRepository.findByName(role));
        }
        return userRoles;
    }

    private void createRoleIfNotExist(String roleName) {
        if (!userRoleRepository.existsByName(roleName)) {
            UserRole role = new UserRole();
            role.setName(roleName);

            userRoleRepository.save(role);
        }
    }
}