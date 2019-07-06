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

    @PostMapping("/create/{fromAirportId}/{toAirportId}/{hotelId}")
    public String addNewTrip(@ModelAttribute("newTrip") Trip trip,
                             @PathVariable("fromAirportId") Long fromAirportId,
                             @PathVariable("toAirportId") Long toAirportId,
                             @PathVariable("hotelId") Long hotelId) {
        tripService.createOrUpdateTripForCountry(trip, fromAirportId, toAirportId, hotelId);
        return "redirect: trip/list-trip";
    }

    @GetMapping("/create/{fromAirport}/{toAirport}/{hotelId}")
    public String addNewTripForm(Model model,
                                 @PathVariable("fromAirport") Long fromAirportId,
                                 @PathVariable("toAirportId") Long toAirportId,
                                 @PathVariable("hotelId") Long hotelId) {
        Optional<Airport> fromAirport = airportService.findAirportById(fromAirportId);
        Optional<Airport> toAirport = airportService.findAirportById(toAirportId);
        Optional<Hotel> hotel = hotelService.findHotelById(hotelId);
        model.addAttribute("newTrip", new Trip());
        model.addAttribute("airportFlyOutId", fromAirportId);
        model.addAttribute("airportFlyOutName", fromAirport.get().getAirportName());
        model.addAttribute("airportFlyBackId", toAirportId);
        model.addAttribute("airportFlyBackName", toAirport.get().getAirportName());
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("hotelName", hotel.get().getHotelName());
        return "trip/form-trip";
    }



}
