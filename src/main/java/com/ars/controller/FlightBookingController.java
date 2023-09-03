package com.ars.controller;


import com.priyanshu.ars.entities.FlightBooking;
import com.priyanshu.ars.model.request.FlightBookingCreateReq;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/flight-booking")
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
