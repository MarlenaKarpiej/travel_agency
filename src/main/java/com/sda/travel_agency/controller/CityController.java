package com.sda.travel_agency.controller;


import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.repository.CityRepository;
import com.sda.travel_agency.service.CityService;
import com.sda.travel_agency.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/city")
@Slf4j
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @PostMapping("create/{countryId}")
    public String addNewCity(@ModelAttribute("newCity")City city, @PathVariable("countryId") Long countryId){
        cityService.createOrUpdateCityForCountry(city, countryId);
        return "redirect:/country/list";
    }

    @GetMapping("create/{countryId}")
    public  String addNewCityForm(Model model, @PathVariable("countryId")Long countryId){
        Optional<Country> country = countryService.findCountryById(countryId);
        model.addAttribute("newCity", new City());
        model.addAttribute("countryId", countryId);
        model.addAttribute("countryName", country.get().getCountryName());
        return "city/form-city";
    }

    @GetMapping("/delete-city/{cityId}")
    public String deleteCity(@PathVariable("cityId") Long id){
        cityService.deleteById(id);
        return "country/list";
    }

    @GetMapping("/edit-city/{cityId}/{countryId}")
    public String editCity(@PathVariable("cityId") Long cityId, @PathVariable("countryId") Long countryId, Model model){
        Optional<City> maybeCity= cityService.findCityById(cityId);

        if(maybeCity.isPresent()) {
            model.addAttribute("city", maybeCity.get());
            model.addAttribute("countryId", countryId);
            return "city/edit-city";
        } else {
            return "redirect:/city/from-city";
        }
    }

    @PostMapping("/edit-city/{countryId}")
    public String editCityPost (@ModelAttribute("cityId") City city, @PathVariable("countryId") Long countryId){
        cityService.createOrUpdateCityForCountry(city, countryId);
        return "redirect:/country/list";
    }


}
