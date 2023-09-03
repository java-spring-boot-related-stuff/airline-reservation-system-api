package com.ars.controller;

import com.priyanshu.ars.model.request.AirportCreateUpdateReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/airport")
public class AirportController {

    @PostMapping
    public Object onboardAirport(@RequestBody AirportCreateUpdateReq airportCreateReq) {
        return null;
    }


}
