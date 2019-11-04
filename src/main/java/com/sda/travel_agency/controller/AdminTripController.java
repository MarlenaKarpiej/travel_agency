package com.sda.travel_agency.controller;

import com.sda.travel_agency.dto.TripDto;
import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.model.MealsType;
import com.sda.travel_agency.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

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

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @GetMapping("/create") //adres url
    public String addNewTripForm(Model model) {
        model.addAttribute("newTrip", new TripDto());
        model.addAttribute("airports", airportService.getAllAirport());
        model.addAttribute("hotels", hotelService.getAllHotel());
        model.addAttribute("mealsTypes", MealsType.values());
        return "trip/form-trip"; //kieruje do adres folderu
    }

    @PostMapping("/create")
    public String addNewTrip(@ModelAttribute("newTrip") TripDto trip, @RequestParam("file") MultipartFile file/*odpowiada za dodanie zdjęcia*/) {
        try {
            tripService.createOrUpdateTripForCountry(trip, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/trip/list-trip";//kieruje na adres url
    }

    @GetMapping("/delete/{tripId}")
    public String delete(@PathVariable("tripId") Long tripId) {
        tripService.deleteById(tripId);
        return "redirect:/trip/list-trip";
    }

    @GetMapping("/edit/{tripId}")
    public String editTripForm(@PathVariable("tripId") Long tripId,
                               Model model) {
        //     TripDto tripDto = tripService.editTrip(tripId);
        Optional<Trip> maybeTrip = tripService.findTripById(tripId);
        if (maybeTrip.isPresent()) {
            model.addAttribute("trip", maybeTrip.get());
            model.addAttribute("airports", airportService.getAllAirport());
            model.addAttribute("hotels", hotelService.getAllHotel());
            model.addAttribute("mealsTypes", MealsType.values());
            model.addAttribute("editedIdentifier", tripId);
            return "trip/edit-trip";
        } else {
            return "redirect:/trip/form-trip";
        }
    }

    @PostMapping("/edit/{tripId}")
    public String editTrip(@PathVariable("tripId") Long editedIdentifier,
                           @ModelAttribute("trip") TripDto trip,
                           @RequestParam("file") MultipartFile file) {
        try {tripService.editTrip(editedIdentifier, trip, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/trip/list-trip";
    }
}
