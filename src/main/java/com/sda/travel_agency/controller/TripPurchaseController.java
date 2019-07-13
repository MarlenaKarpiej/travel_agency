package com.sda.travel_agency.controller;


import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.service.CountryService;
import com.sda.travel_agency.service.TripPurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/purchase/")
@Slf4j
public class TripPurchaseController {

    private final TripPurchaseService tripPurchaseService;

//    @GetMapping("/create")
//    public String createPurchaseForm(Model model) {
//        model.addAttribute("tripPurchase", new tripPurchase());
//        return "purchase/form";
//    }




}
