package com.sda.travel_agency.controller;

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

    @PostMapping("/create/{airportFlyOutId}/{airportFlyBackId}/{hotelId}")
    public String addNewTrip(@ModelAttribute("newTrip") Trip trip,
                             @PathVariable("airportFlyOutId") Long airportFlyOutId,
                             @PathVariable("airportFlyBackId") Long airportFlyBackId,
                             @PathVariable("hotelId") Long hotelId) {
        tripService.createOrUpdateTripForCountry(trip, airportFlyOutId, airportFlyBackId, hotelId);
        return "redirect: trip/list-trip";
    }

    @GetMapping("/create/{airportFlyOutId}/{airportFlyBackId}/{hotelId}")
    public String addNewTripForm(Model model,
                                 @PathVariable("airportFlyOutId") Long airportFlyOutId,
                                 @PathVariable("airportFlyBackId") Long airportFlyBackId,
                                 @PathVariable("hotelId") Long hotelId) {
        Optional<Airport> airportFlyOut = airportService.findAirportById(airportFlyOutId);
        Optional<Airport> airportFlyBack = airportService.findAirportById(airportFlyBackId);
        Optional<Hotel> hotel = hotelService.findHotelById(hotelId);
        model.addAttribute("newTrip", new Trip());
        model.addAttribute("airportFlyOutId", airportFlyOutId);
        model.addAttribute("airportFlyOutName", airportFlyOut.get().getAirportName());
        model.addAttribute("airportFlyBackId", airportFlyBackId);
        model.addAttribute("airportFlyBackName", airportFlyBack.get().getAirportName());
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("hotelName", hotel.get().getHotelName());
        return "trip/form-trip";
    }



}
