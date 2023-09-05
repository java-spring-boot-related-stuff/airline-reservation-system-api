package com.ars.controller;

import com.ars.entities.Airport;
import com.ars.model.request.AirportCreateUpdateReq;
import com.ars.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @PostMapping
    public Airport onboardAirport(@RequestBody AirportCreateUpdateReq airportCreateReq) {

        return airportService.createAirport(airportCreateReq);

    }


}