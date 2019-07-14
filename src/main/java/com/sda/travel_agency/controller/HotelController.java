package com.sda.travel_agency.controller;


import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.entity.Hotel;
import com.sda.travel_agency.model.StarRating;
import com.sda.travel_agency.service.CityService;
import com.sda.travel_agency.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/hotel/")
@Slf4j
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CityService cityService;

    @PostMapping("/create/{cityId}")
    public String addNewHotel(@ModelAttribute("newHotel") Hotel hotel, @PathVariable("cityId") Long cityId) {
        hotelService.createOrUpdateHotelForCity(hotel, cityId);
        return "redirect:/admin/hotel/list";
    }

    @GetMapping("/create/{cityId}")
    public String addNewHotelForm(Model model, @PathVariable("cityId") Long cityId) {
        Optional<City> city = cityService.findCityById(cityId);
        model.addAttribute("newHotel", new Hotel());
        model.addAttribute("cityId", cityId);
        model.addAttribute("starRatings", StarRating.values());
        model.addAttribute("cityName", city.get().getCityName());
        return "hotel/form-hotel";
    }

    @GetMapping("/delete-hotel/{hotelId}")
    public String deleteHotel(@PathVariable("hotelId") Long hotelId) {
        hotelService.deleteById(hotelId);
        return "redirect:/country/list";
    }

    @GetMapping("/edit-hotel/{hotelId}/{cityId}")
    public String editHotel(@PathVariable("hotelId") Long hotelId, @PathVariable("cityId") Long cityId, Model model) {
        Optional<Hotel> maybeHotel = hotelService.findHotelById(hotelId);
        Optional<City> city = cityService.findCityById(cityId);
        if (maybeHotel.isPresent()) {
            model.addAttribute("hotel", maybeHotel.get());
            model.addAttribute("cityId", cityId);
            model.addAttribute("cityName", city.get().getCityName());
            return "hotel/edit-hotel";
        } else {
            return "redirect:/hotel/form-hotel";
        }
    }

    @PostMapping("/edit-hotel/{hotelId}/{cityId}")
    public String editHotelPost(@ModelAttribute("hotel") Hotel hotel, @PathVariable("hotelId") Hotel hotelId, @PathVariable("cityId") Long cityId) {
        hotelService.createOrUpdateHotelForCity(hotel, cityId);
        return "redirect:/country/list";
    }

    @GetMapping("/list/{cityId}")
    public String listHotels(@PathVariable(name = "cityId") Long cityId,
                             Model model) {
        model.addAttribute("cityId", cityId);
        model.addAttribute("hotels", hotelService.findHotelByCity(cityService.findCityById(cityId).get()));
        return "hotel/list";
    }

    @GetMapping("/list")
    public String listHotels(Model model) {
        model.addAttribute("hotels", hotelService.findAllHotels());
        return "hotel/list";
    }
}
