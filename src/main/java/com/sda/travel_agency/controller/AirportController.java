package com.sda.travel_agency.controller;

import com.sda.travel_agency.entity.Airport;
import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.service.AirportService;
import com.sda.travel_agency.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/airport/")
@Slf4j
public class AirportController {


    @Autowired
    private AirportService airportService;
    @GetMapping("/list")
    public String listHotels( Model model) {
        model.addAttribute("airports", airportService.findAllAirports());
        return "airport/list";
    }
}

