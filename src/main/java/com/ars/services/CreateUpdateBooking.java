package com.ars.services;

import com.ars.entities.Flight;
import com.ars.entities.FlightBooking;
import com.ars.model.request.FlightBookingCreateReq;
import com.ars.model.request.FlightCreateUpdateReq;
import com.ars.model.request.FlightScheduleCreateUpdateReq;

public interface CreateUpdateBooking {

     FlightBooking createBooking (FlightBookingCreateReq flightCreateUpdateReq);

     FlightBooking updateBooking (FlightBookingCreateReq  flightCreateUpdateReq);

     FlightBooking cancelBooking (String bookingId);

}
