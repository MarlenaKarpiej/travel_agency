package com.sda.travel_agency.controller;

import com.sda.travel_agency.dto.TripDto;
import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.model.MealsType;
import com.sda.travel_agency.service.*;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String addNewTrip(@ModelAttribute("newTrip") TripDto trip, @RequestParam("file") MultipartFile file) {
        try {
            tripService.createOrUpdateTripForCountry(trip, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        model.addAttribute("editedIdentifier", tripId);
        return "trip/edit-trip";
    }

    @PostMapping("/edit/{tripId}")
    public String editTrip(@ModelAttribute("trip") TripDto trip, @PathVariable("tripId") Long editedIdentifier) {
        tripService.editTrip(editedIdentifier, trip);
        return "redirect:/trip/list-trip";
    }


   // TODO
//
//    @GetMapping("/sort-and-page")
//    public List<TripDto> sortAndPage(@RequestParam("page") Integer page,
//                                          @RequestParam("size") Integer size,
//                                          @RequestParam("sortOrder") Sort.Direction sortOrder){
//        Pageable pageable = PageRequest.of(page, size, sortOrder,"id");
//        return tripService.findAll(pageable).getContent();
//    }
}
