package com.ars.controller;

import com.priyanshu.ars.model.request.FlightCreateUpdateReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/flight")
public class FlightController {

    @PostMapping
    public Object onboardFlight(@RequestBody FlightCreateUpdateReq flightCreateReq) {
        return null;
    }


}
