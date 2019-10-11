package com.sda.travel_agency.controller;


import com.sda.travel_agency.dto.TripDto;
import com.sda.travel_agency.entity.Airport;
import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.model.MealsType;
import com.sda.travel_agency.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/trip/")
@Slf4j
public class TripController {

    @Autowired
    private final TripService tripService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

//    @GetMapping("/list-trip/offer")
//    public String tripList(Model model){
//        List<Trip> trips = tripService.getAllTrip();
//        model.addAttribute("trips", trips);
//        return "trip/trip-offer";
//    }

    @GetMapping("/list-trip")
    public String tripList(Model model){
        List<Trip> trips = tripService.getAllTrip();
        model.addAttribute("trips", trips);
        model.addAttribute("country", countryService.getAllCountry());
        model.addAttribute("city", cityService.getAllCity());
        return "trip/list-trip";
    }

    @GetMapping("/details/{tripId}")
    public String trpDetails(Model model, @PathVariable("tripId") Long tripId) {
        Optional<Trip> maybeTrip = tripService.findTripById(tripId);
        if (maybeTrip.isPresent()) {
            model.addAttribute("trip", maybeTrip.get());
            model.addAttribute("airports", airportService.getAllAirport());
            model.addAttribute("hotels", hotelService.getAllHotel());
            model.addAttribute("country", countryService.getAllCountry());
            model.addAttribute("city", cityService.getAllCity());
            model.addAttribute("mealsTypes", MealsType.values());
            return "trip/details";
        }
        return "trip/trip-offer";
    }
    


}
