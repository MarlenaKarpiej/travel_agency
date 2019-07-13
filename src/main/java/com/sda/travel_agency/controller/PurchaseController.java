package com.sda.travel_agency.controller;


import com.sda.travel_agency.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/purchase/")
@Slf4j
public class PurchaseController {

    private final PurchaseService purchaseService;





}
