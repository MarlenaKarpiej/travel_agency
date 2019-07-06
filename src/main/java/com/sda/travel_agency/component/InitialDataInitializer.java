package com.sda.travel_agency.component;

import com.sda.travel_agency.entity.Continent;
import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitialDataInitializer implements
        ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        dodajPolandie();

        // tutaj piszemy logikę
        // w tej klasie można dokonać @autowired i np. przygotować jakieś inicjalne dane.
    }

    private void dodajPolandie() {
        if(!countryRepository.existsByCountryName("Poland")){
            countryRepository.save(new Country("Poland", Continent.EUROPE));
        }
    }
}