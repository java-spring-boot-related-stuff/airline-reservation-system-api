package com.ars.controller;


import com.ars.entities.FlightBooking;
import com.ars.model.request.FlightBookingCreateReq;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight-booking")
public class FlightBookingController {


    @PostMapping
    public FlightBooking createBooking(@RequestBody FlightBookingCreateReq bookingCreationReq) {
        return null;
    }

    @PostMapping("/cancel/{bookingId}")
    public Object cancelBooking(@PathVariable String bookingId) {
        return null;
    }
}
