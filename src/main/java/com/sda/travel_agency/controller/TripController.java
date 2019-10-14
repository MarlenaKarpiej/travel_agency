package com.sda.travel_agency.controller;

import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.model.MealsType;
import com.sda.travel_agency.repository.TripRepository;
import com.sda.travel_agency.service.*;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private TripRepository tripRepository;


    //    @GetMapping("/list-trip/page/size")
    @GetMapping("/list-trip")
    public String tripList(Model model,
                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                           @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Trip> trips = tripService.getAllTrip(pageable);
        model.addAttribute("trips", trips);
        model.addAttribute("size", size);
        model.addAttribute("country", countryService.getAllCountry());
        model.addAttribute("city", cityService.getAllCity());
        return "trip/list-trip";
    }

    @GetMapping("/details/{tripId}")
    public String trpDetails(Model model, @PathVariable("tripId") Long tripId) {
        Optional<Trip> maybeTrip = tripService.findTripById(tripId);
        if (maybeTrip.isPresent()) {
            if (maybeTrip.get().getData() != null) {
                model.addAttribute("base64Data", new String(Base64.encode(maybeTrip.get().getData())));
            }
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
