package com.ars.controller;


import com.ars.entities.FlightBooking;
import com.ars.model.request.FlightBookingCreateReq;
import com.ars.services.CreateUpdateBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight-booking")
public class FlightBookingController {
    @Autowired
    private CreateUpdateBooking createUpdateBooking;


    @PostMapping
    public FlightBooking createBooking(@RequestBody FlightBookingCreateReq bookingCreationReq) {
        return createUpdateBooking.createBooking(bookingCreationReq);
    }

    @PostMapping("/cancel/{bookingId}")
    public Object cancelBooking(@PathVariable String bookingId) {

        return createUpdateBooking.cancelBooking(bookingId);
    }
}
