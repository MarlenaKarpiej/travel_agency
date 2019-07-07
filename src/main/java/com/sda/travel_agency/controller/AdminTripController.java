package com.sda.travel_agency.controller;

import com.sda.travel_agency.dto.TripDto;
import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.service.AirportService;
import com.sda.travel_agency.service.HotelService;
import com.sda.travel_agency.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/trip/")
@Slf4j
public class AdminTripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private AirportService airportService;

    @GetMapping("/create") //adres url
    public String addNewTripForm(Model model) {
        model.addAttribute("newTrip", new TripDto());
        model.addAttribute("airports", airportService.getAllAirport());
        model.addAttribute("hotels", hotelService.getAllHotel());
        return "trip/form-trip"; //kieruje do adres folderu
    }

    @PostMapping("/create")
    public String addNewTrip(@ModelAttribute("newTrip") TripDto trip) {
        tripService.createOrUpdateTripForCountry(trip);
        return "redirect:/admin/trip/list-trip";//kieruje na adres url
    }

    @GetMapping("/delete/{tripId}")
    public String delete(@PathVariable("tripId") Long tripId) {
        tripService.deleteById(tripId);
        return "redirect:/admin/trip/list-trip";
    }

    @GetMapping("/edit/{tripId}")
    public String editTripForm(@PathVariable("tripId") Long tripId, Model model) {
        TripDto tripDto = tripService.editTrip(tripId);
        model.addAttribute("trip", tripDto);
        model.addAttribute("airports", airportService.getAllAirport());
        model.addAttribute("hotels", hotelService.getAllHotel());

        return "trip/edit-trip";
    }

    @PostMapping("/edit/{tripId}")
    public String editTrip(@ModelAttribute("trip") Trip trip) {
        tripService.editTrip(trip);
        return "redirect:/admin/trip/list-trip";
    }

    @GetMapping("/list-trip")
    public String tripList(Model model){
        List<Trip> trips = tripService.getAllTrip();
        model.addAttribute("trips", trips);
        return "trip/list-trip";
    }
}
