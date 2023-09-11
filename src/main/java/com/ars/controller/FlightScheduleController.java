package com.ars.controller;

import com.ars.entities.Flight;
import com.ars.entities.FlightSchedule;
import com.ars.model.request.FlightCreateUpdateReq;
import com.ars.model.request.FlightScheduleCreateUpdateReq;
import com.ars.services.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight-schedule")
public class FlightScheduleController {

    @Autowired
    private FlightScheduleService flightScheduleService;

    @PostMapping
    public FlightSchedule flightSchedule(@RequestBody FlightScheduleCreateUpdateReq req) {
        return flightScheduleService.createFlightSchedule(req);
    }
}

