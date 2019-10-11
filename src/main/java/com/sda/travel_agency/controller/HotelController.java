package com.sda.travel_agency.controller;

import com.sda.travel_agency.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hotel/")
@Slf4j
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/list")
    public String listHotels(Model model) {
        model.addAttribute("hotels", hotelService.findAllHotels());
        return "hotel/list";
    }
}
