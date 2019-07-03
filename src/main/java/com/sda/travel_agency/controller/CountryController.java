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

    @GetMapping("/create")
    public String createCountryForm(Model model) {
        model.addAttribute("country", new Country());
        return "country/form";
    }

    @PostMapping("/create")
    public String createCountry(@ModelAttribute("country") Country country) {
        countryService.createCountry(country);
        log.info("Add new country {}", country);

        return "redirect:/country/list";
    }

    @GetMapping("edit/{id}")
    public String editCountryForm(@PathVariable("id") Long id, Model model){
        Optional<Country> maybeCountry = countryService.findCountryById(id);

        if(maybeCountry.isPresent()){
            model.addAttribute("country", maybeCountry.get());
            return "country/edit-form";
        }else {
            return "redirect:/country/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editCountry(@ModelAttribute("country") Country country){
        countryService.editCountry(country);
        return "redirect:/country/list";
    }

    @GetMapping("/list")
    public String countryList(Model model){
        Iterable<Country> countries = countryService.getAllCountry();
        model.addAttribute("countries", countries);

        return "country/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        countryService.deleteById(id);
        return "redirect:/country/list";
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
