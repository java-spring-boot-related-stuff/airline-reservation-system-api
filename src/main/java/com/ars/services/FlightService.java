package com.ars.services;

import com.ars.entities.Flight;
import com.ars.model.request.FlightCreateUpdateReq;

public interface FlightService {

    Flight createFlight(FlightCreateUpdateReq request);
}
