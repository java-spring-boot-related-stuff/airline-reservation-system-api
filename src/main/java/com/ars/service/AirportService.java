package com.ars.service;

import com.ars.entities.Airport;
import com.ars.model.request.AirportCreateUpdateReq;

public interface AirportService {

    Airport createAirport(AirportCreateUpdateReq request);

}