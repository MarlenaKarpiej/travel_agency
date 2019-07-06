package com.sda.travel_agency.controller;

import com.sda.travel_agency.dto.TripDto;
import com.sda.travel_agency.entity.*;
import com.sda.travel_agency.service.AirportService;
import com.sda.travel_agency.service.HotelService;
import com.sda.travel_agency.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/trip/")
@Slf4j
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private AirportService airportService;

    @PostMapping("/create/{fromAirportId}/{toAirportId}/{hotelId}")
    public String addNewTrip(@ModelAttribute("newTrip") TripDto trip) {
        tripService.createOrUpdateTripForCountry(trip);
        return "redirect: trip/list-trip";
    }

    @GetMapping("/create")
    public String addNewTripForm(Model model) {
        model.addAttribute("newTrip", new TripDto());
        model.addAttribute("airports", airportService.getAllAirport());
        model.addAttribute("hotels", hotelService.getAllHotel());
        return "trip/form-trip";
    }



}
