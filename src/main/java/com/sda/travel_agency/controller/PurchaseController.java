package com.sda.travel_agency.controller;


import com.sda.travel_agency.entity.AppUser;
import com.sda.travel_agency.entity.Purchase;
import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/purchase/")
@Slf4j
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final TripService tripService;
    private final UserService userService;


    // todo: mapping na zakup wycieczki.
    //  z wycieczki przesyłamy identyfikator wycieczki
    //  z principal wybieramy zalogowanego użytkownika

    @PostMapping("/buy/{tripId}")
    public String createPurchase(@RequestHeader(value = "referer", required = false) final String referer,
                                 Model model,
                                 @ModelAttribute("newPurchase") Purchase purchase,
                                 @PathVariable("tripId") Long tripId,
                                 Principal principal) {

        String username = principal.getName();
        if (username == null) {
            return "redirect:/login";
        }
        Optional<AppUser> appUserOptional = userService.findUserByUsername(username);
        Optional<Trip> maybeTrip = tripService.findTripById(tripId);
        if (maybeTrip.isPresent()) {
            // weryfikacja ilosci miejsc
            Trip trip = maybeTrip.get();

            int totalSeatsToBuy = purchase.getChildSeats() + purchase.getAdultSeats();

            int totalSeatsTaken = tripService.getNumberOfTakenSeats(tripId);

            if ((trip.getSeatsNumber() - totalSeatsTaken) < (totalSeatsToBuy)) {
                model.addAttribute("message", "Too many seats, available number is: " + (trip.getSeatsNumber() - totalSeatsTaken));
                model.addAttribute("newPurchase", purchase);
                model.addAttribute("newPurchaseTrip", maybeTrip.get());
                model.addAttribute("username", username);
                model.addAttribute("tripId", tripId);

                return "buy";
            }
            if (appUserOptional.isPresent()) {
                AppUser appUser = appUserOptional.get();

                purchase.setCart(appUser.getCart());
                purchase.setTrip(trip);

                purchaseService.save(purchase);
                // jest wszystko ok.
                return "redirect:/cart/";
            }
        }
        if (referer != null) {
            return "redirect:" + referer;
        } else {
            return "redirect:/trip/list-trip";
        }
    }

    @GetMapping("/buy/{tripId}")
    public String buyTrip(Principal principal,
                          Model model,
                          @PathVariable("tripId") Long tripId) {
//        Principal reprezentuje zalogowanego użytkownika
//        z użytkownika wyciągamy koszyk
//        tworzymy obiekt purchase, dodajemy do niego trip
//        do purchase dodajemy nasz koszyk. zapisujemy purchase.

        String username = principal.getName();
        Optional<Trip> maybeTrip = tripService.findTripById(tripId);
        if (maybeTrip.isPresent()) {
            model.addAttribute("newPurchase", new Purchase());
            model.addAttribute("newPurchaseTrip", maybeTrip.get());
            model.addAttribute("username", username);
            model.addAttribute("tripId", tripId);
            return "buy";
        } else {
            return "trip/list-trip";
        }


    }


}
