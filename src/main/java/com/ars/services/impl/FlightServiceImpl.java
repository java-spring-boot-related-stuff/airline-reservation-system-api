package com.ars.services.impl;

import com.ars.entities.Flight;
import com.ars.model.request.FlightCreateUpdateReq;
import com.ars.repository.FlightRepository;
import com.ars.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;
   @Override
   public  Flight createFlight(FlightCreateUpdateReq request){
       Flight flight =new Flight();
       flight.setId(UUID.randomUUID().toString());
       flight.setName(request.getName());
       flight.setCreatedAt(LocalDateTime.now());
       flight.setCreatedBy("system");
       flight.setLastUpdatedBy("system");
       flight.setLastUpdatedAt(LocalDateTime.now());
       flightRepository.save(flight);
       return flight;

   }


}
