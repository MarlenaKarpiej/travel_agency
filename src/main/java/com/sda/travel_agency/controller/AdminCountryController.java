package com.sda.travel_agency.controller;

import com.sda.travel_agency.entity.Continent;
import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/country/")
@Slf4j
public class AdminCountryController {

    private final CountryService countryService;

    @GetMapping("/create")
    public String createCountryForm(Model model) {
        model.addAttribute("country", new Country());
        model.addAttribute("continents", Continent.values());
        return "country/form";
    }

    @PostMapping("/create")
    public String createCountry(@ModelAttribute("country") Country country) {
        countryService.createCountry(country);

        return "redirect:/country/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        countryService.deleteById(id);
        return "redirect:/country/list";
    }

    @GetMapping("/edit/{id}")
    public String editCountryForm(@PathVariable("id") Long id, Model model){
        Optional<Country> maybeCountry = countryService.findCountryById(id);

        if(maybeCountry.isPresent()){
            model.addAttribute("country", maybeCountry.get());
            return "country/edit-form";
        }else {
            return "redirect:/admin/country/create";
        }
    }

    @PostMapping("/edit/{id}")
    public String editCountry(@ModelAttribute("country") Country country){
        countryService.editCountry(country);
        return "redirect:/country/list";
    }

}
