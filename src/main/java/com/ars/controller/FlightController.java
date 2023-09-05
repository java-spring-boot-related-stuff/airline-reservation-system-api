package com.ars.controller;

import com.ars.entities.Flight;
import com.ars.model.request.FlightCreateUpdateReq;
import com.ars.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public Flight onboardFlight(@RequestBody FlightCreateUpdateReq flightCreateReq) {
        return flightService.createFlight(flightCreateReq);
    }


}
