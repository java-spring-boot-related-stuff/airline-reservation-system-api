package com.ars.services.impl;

import com.ars.entities.Airport;
import com.ars.entities.Flight;
import com.ars.entities.FlightSchedule;
import com.ars.entities.Pilot;
import com.ars.exception.BadRequestException;
import com.ars.model.request.FlightCreateUpdateReq;
import com.ars.model.request.FlightScheduleCreateUpdateReq;
import com.ars.repository.AirportRepository;
import com.ars.repository.FlightRepository;
import com.ars.repository.FlightScheduleRepository;
import com.ars.repository.PilotRepository;
import com.ars.services.FlightScheduleService;
import com.ars.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class FlightScheduleImpl implements FlightScheduleService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PilotRepository pilotRepository;
    @Autowired
    private AirportRepository airportRepository;

    @Autowired
   private  FlightScheduleRepository flightScheduleRepository;

    @Override
    public FlightSchedule createFlightSchedule(FlightScheduleCreateUpdateReq request) {
        Flight flight = flightRepository.findById(request.getFlightId()).orElseThrow(() -> new
                BadRequestException ("flight with id" + request.getFlightId() +"does not exsist"));

        Pilot pilot = pilotRepository.findById(request.getPilotId()).orElseThrow(() -> new
                BadRequestException ("pilotId with id" + request.getPilotId() +"does not exsist"));

        Airport sourceAirport = airportRepository.findById(request.getSourceAirportId()).orElseThrow(() -> new
                BadRequestException ("flight with id" + request.getSourceAirportId() +"does not exsist"));

        Airport destinationAirport = airportRepository.findById(request.getDestinationAirportId()).orElseThrow(() -> new
                BadRequestException ("flight with id" + request.getDestinationAirportId() +"does not exsist"));

        FlightSchedule flightSchedule=new FlightSchedule();
        flightSchedule.setId(UUID.randomUUID().toString());
        flightSchedule.setFlight(flight);
        flightSchedule.setPilot(pilot);
        flightSchedule.setJourneyStartDate(request.getJourneyStartDate());
        flightSchedule.setSourceAirport(sourceAirport);
        flightSchedule.setJourneyEndDate(request.getJourneyEndDate());
        flightSchedule.setDestAirport(destinationAirport);
        flightSchedule.setMaxTravellerCapacity(request.getMaxTravelCapacity());
        flightSchedule.setMaxWaitingCapacity(request.getMaxWaitingCapacity());
        flightSchedule.setCreatedAt(LocalDateTime.now());
        flightSchedule.setCreatedBy("system");
        flightSchedule.setLastUpdatedAt(LocalDateTime.now());
        flightSchedule.setLastUpdatedBy("system");
        flightScheduleRepository.save(flightSchedule);
        return flightSchedule;

    }
}
