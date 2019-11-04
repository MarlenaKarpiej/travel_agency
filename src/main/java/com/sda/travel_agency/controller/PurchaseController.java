package com.sda.travel_agency.controller;


import com.sda.travel_agency.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/purchase/")
@Slf4j
public class PurchaseController {

    private final PurchaseService purchaseService;


    // todo: mapping na zakup wycieczki.
    //  z wycieczki przesyłamy identyfikator wycieczki
    //  z principal wybieramy zalogowanego użytkownika

//    @GetMapping("/buy")
//    public String buyTrip(Principal principal){
        // Principal reprezentuje zalogowanego użytkownika
        // username = principal.getName();
//        String username = principal.getName();
        // z użytkownika wyciągamy koszyk

        // tworzymy obiekt purchase, dodajemy do niego trip
        // do purchase dodajemy nasz koszyk. zapisujemy purchase.
//    }
}
