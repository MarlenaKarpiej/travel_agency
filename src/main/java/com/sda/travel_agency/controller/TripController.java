package com.sda.travel_agency.controller;


import com.sda.travel_agency.dto.TripDto;
import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/trip/")
@Slf4j
public class TripController {

    @Autowired
    private final TripService tripService;

    @GetMapping("/list-trip")
    public String tripList(Model model){
        List<Trip> trips = tripService.getAllTrip();
        model.addAttribute("trips", trips);
        return "trip/list-trip";
    }

}
