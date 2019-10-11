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
        addCountry("Poland", Continent.EUROPE);
        addCountry("Germany", Continent.EUROPE);
        addCountry("Italy", Continent.EUROPE);
        addCountry("Spain", Continent.EUROPE);
        addCountry("Egypt", Continent.AFRICA);
        addCountry("USA", Continent.NORTH_AMERICA);
        addCountry("Thailand", Continent.ASIA);

        addCity("Warsaw", "Poland");
        addCity("Krakow", "Poland");
        addCity("Munich ", "Germany");
        addCity("Milan", "Italy");
        addCity("Rome", "Italy");
        addCity("Barcelona", "Spain");
        addCity("Hurghada", "Egypt");
        addCity("New York City","USA");
        addCity("Bangkok", "Thailand");

        addAirport("Warsaw Chopin Airport", "Warsaw");
        addAirport("Kraków John Paul II International Airport", "Krakow");
        addAirport("Munich International Airport", "Munich");
        addAirport("Malpensa Airport", "Milan");
        addAirport("Leonardo da Vinci International Airport", "Rome");
        addAirport("Barcelona-El Prat Airport", "Barcelona");
        addAirport("LaGuardia Airport", "New York City");
        addAirport("John F. Kennedy International Airport", "New York City");
        addAirport("Don Mueang International Airport", "Bangkok");
        addAirport("Bangkok International Airport", "Bangkok");

        addHotel("Matylda Old Town Apartment", "Warsaw", StarRating.THREE, "just perfect");
        addHotel("B&B Hotel", "Krakow", StarRating.FOUR, "friendly staff");
        addHotel("Grand Hotel", "Milan", StarRating.THREE, "excellent location");
        addHotel("Barcelona Apartments Plaza", "Barcelona", StarRating.THREE, "great location");
        addHotel("Moderne Hotel", "New York City", StarRating.FIVE, "great neighbourhood");
        addHotel("Wild Orchid Villa", "Bangkok", StarRating.FOUR, "very comfortable");

        addTrip("Warsaw Chopin Airport",
                LocalDate.of(2019, 12, 3),
                "Kraków John Paul II International Airport",
                LocalDate.of(2019, 12, 12),
                "B&B Hotel",
                2500,
                1000,
                MealsType.BB,
                45,
                true);

        addTrip("Warsaw Chopin Airport",
                LocalDate.of(2019, 12, 23),
                "Barcelona-El Prat Airport",
                LocalDate.of(2019, 12, 30),
                "Barcelona Apartments Plaza",
                8500,
                5000,
                MealsType.FB,
                15,
                true);

        addTrip("Warsaw Chopin Airport",
                LocalDate.of(2020, 1, 3),
                "Malpensa Airport",
                LocalDate.of(2020, 1, 10),
                "Grand Hotel",
                3300,
                1800,
                MealsType.HB,
                15,
                true);

        addTrip("Kraków John Paul II International Airport",
                LocalDate.of(2020, 7, 12),
                "Barcelona-El Prat Airport",
                LocalDate.of(2020, 7, 19),
                "Barcelona Apartments Plaza",
                9500,
                6000,
                MealsType.ALL_INC,
                19,
                true);

        addTrip("Warsaw Chopin Airport",
                LocalDate.of(2020, 7, 12),
                "Bangkok International Airport",
                LocalDate.of(2020, 7, 19),
                "Wild Orchid Villa",
                9500,
                6000,
                MealsType.ALL_INC,
                19,
                true);

        addTrip("Kraków John Paul II International Airport",
                LocalDate.of(2019, 12, 3),
                "Bangkok International Airport",
                LocalDate.of(2019, 12, 12),
                "Wild Orchid Villa",
                2500,
                1000,
                MealsType.BB,
                45,
                true);

        addTrip("Warsaw Chopin Airport",
                LocalDate.of(2019, 12, 23),
                "Barcelona-El Prat Airport",
                LocalDate.of(2019, 12, 30),
                "Barcelona Apartments Plaza",
                8500,
                5000,
                MealsType.FB,
                15,
                false);

        addTrip("Kraków John Paul II International Airport",
                LocalDate.of(2020, 1, 3),
                "Malpensa Airport",
                LocalDate.of(2020, 1, 10),
                "Grand Hotel",
                3300,
                1800,
                MealsType.HB,
                15,
                false);

        addTrip("Kraków John Paul II International Airport",
                LocalDate.of(2020, 7, 12),
                "Barcelona-El Prat Airport",
                LocalDate.of(2020, 7, 19),
                "Barcelona Apartments Plaza",
                9500,
                6000,
                MealsType.ALL_INC,
                19,
                false);

        addTrip("Warsaw Chopin Airport",
                LocalDate.of(2020, 6, 12),
                "Bangkok International Airport",
                LocalDate.of(2020, 6, 19),
                "Wild Orchid Villa",
                7500,
                3000,
                MealsType.ALL_INC,
                19,
                true);

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

    private void addTrip(String fromAirport, LocalDate flyOut, String toAirport, LocalDate flyBack,
                         String hotelName, float adultPrice, float childPrice, MealsType mealsType, int seatsNumber, boolean promoted) {

        Airport airportFrom = airportRepository.findByAirportName(fromAirport);
        Airport airportTo = airportRepository.findByAirportName(toAirport);
        Hotel hotel = hotelRepisitory.findByHotelName(hotelName);

        Trip trip = new Trip(airportFrom, airportTo, hotel, flyOut, flyBack, mealsType, adultPrice, childPrice, seatsNumber, promoted);
        tripRepository.save(trip);
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