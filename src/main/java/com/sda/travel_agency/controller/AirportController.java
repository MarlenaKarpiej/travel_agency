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
@RequestMapping("/airport")
@Slf4j
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private CityService cityService;

    @PostMapping("create/{cityId}")
    public String addNewAirport(@ModelAttribute("newAirport") Airport airport, @PathVariable("cityId") Long cityId) {
        airportService.createOrUpdateAirportForCity(airport, cityId);
        return "redirect:/country/list";
    }

    @GetMapping("create/{cityId}")
    public String addNewAirportForm(Model model, @PathVariable("cityId") Long cityId) {
        Optional<City> city = cityService.findCityById(cityId);
        model.addAttribute("newAirport", new Airport());
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityName", city.get().getCityName());
        return "airport/form-airport";
    }

    @GetMapping("/delete-airport/{airportId}")
    public String deleteAirport(@PathVariable("airportId") Long id) {
        airportService.deleteById(id);
        return "redirect:/country/list";
    }

    @GetMapping("edit-airport/{airportId}/{cityId}")
    public String editAirport(@PathVariable("airportId") Long airportId, @PathVariable("cityId") Long cityId, Model model) {
        Optional<Airport> maybeAirport = airportService.findAirportById(airportId);

        if (maybeAirport.isPresent()) {
            model.addAttribute("airport", maybeAirport.get());
            model.addAttribute("cityId", cityId);
            return "airport/edit-airport";
        } else {
            return "redirect:/airport/form-airport";
        }
    }

    @PostMapping("/edit-airport/{cityId}")
    public String editAirport(@ModelAttribute("airportId") Airport airport, @PathVariable("cityId") Long cityId) {
        airportService.createOrUpdateAirportForCity(airport, cityId);
        return "redirect:/country/list";
    }

}
