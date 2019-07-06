package com.sda.travel_agency.controller;


import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.model.FilterForm;
import com.sda.travel_agency.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/country")
@Slf4j
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/index")
    public String homePage(){
        return "/index";
    }

    @GetMapping("/list")
    public String countryList(Model model){
        Iterable<Country> countries = countryService.getAllCountry();
        model.addAttribute("countries", countries);
        return "country/list";
    }

    @GetMapping("/find-by-name")
    public String findByNameForm(Model model) {
        model.addAttribute("filterForm", new FilterForm());
        return "country/find-by-name";
    }

    @PostMapping("/find-by-name")
    public String findFilter(@ModelAttribute("filterForm") FilterForm filterForm,
                                     Model model) {
        List<Country> foundCountry = countryService.findAllByCountryNameContaining(filterForm.getCountryName());
        model.addAttribute("countries", foundCountry);
        return "country/list";
    }
}
