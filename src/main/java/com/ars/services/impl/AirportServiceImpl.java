package com.ars.services.impl;

import com.ars.entities.Airport;
import com.ars.model.request.AirportCreateUpdateReq;
import com.ars.repository.AirportRepository;
import com.ars.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;
    @Override
    public Airport createAirport(AirportCreateUpdateReq request) {
        Airport airport = new Airport();
        airport.setId(UUID.randomUUID().toString());
        airport.setName(request.getName());
        airport.setCity(request.getCity());
        airport.setCreatedAt(LocalDateTime.now());
        airport.setCreatedBy("system");
        airport.setLastUpdatedAt(LocalDateTime.now());
        airport.setLastUpdatedBy("system");
        airportRepository.save(airport);
        return airport;
    }
}
