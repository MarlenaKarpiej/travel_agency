package com.sda.travel_agency.controller;

import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.service.AirportService;
import com.sda.travel_agency.service.HotelService;
import com.sda.travel_agency.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @PostMapping("/create")
    public String addNewTrip(@ModelAttribute("newTrip") Trip trip,
                             @PathVariable("airportFlyOutId") Long airportFlyOutId,
                             @PathVariable("airportFlyBackId") Long airportFlyBackId,
                             @PathVariable("hotelId") Long hotelId) {
        tripService.createOrUpdateTripForCountry(trip, airportFlyOutId, airportFlyBackId, hotelId);
        return "trip/form-trip";
    }


}
