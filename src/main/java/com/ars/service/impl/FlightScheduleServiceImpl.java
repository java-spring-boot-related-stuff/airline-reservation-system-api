package com.ars.service.impl;


import com.ars.entities.Airport;
import com.ars.entities.Flight;
import com.ars.entities.FlightSchedule;
import com.ars.entities.Pilot;
import com.ars.exception.BadRequestException;
import com.ars.model.request.FlightScheduleCreateUpdateReq;
import com.ars.repository.AirportRepository;
import com.ars.repository.FlightRepository;
import com.ars.repository.FlightScheduleRepository;
import com.ars.repository.PilotRepository;
import com.ars.service.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {

    @Autowired
    private FlightScheduleRepository flightScheduleRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PilotRepository pilotRepository;

    @Autowired
    private AirportRepository airportRepository;


    @Override
    public FlightSchedule createFlightSchedule(FlightScheduleCreateUpdateReq request) {

        Flight flight= flightRepository.findById(request.getFlightId())
                .orElseThrow(() -> new BadRequestException("Flight With ID "+ request.getFlightId() + " Does Not Exists."));
        Pilot pilot= pilotRepository.findById(request.getPilotId())
                .orElseThrow(() -> new BadRequestException("Pilot With ID "+ request.getPilotId() + " Does Not Exists."));
        Airport sourceAirport= airportRepository.findById(request.getSourceAirportId())
                .orElseThrow(() -> new BadRequestException("Source Airport With ID "+ request.getSourceAirportId() + " Does Not Exists."));
        Airport destAirport= airportRepository.findById(request.getDestAirportId())
                .orElseThrow(() -> new BadRequestException("Destination Airport With ID "+ request.getDestAirportId() + " Does Not Exists."));


        FlightSchedule schedule= new FlightSchedule();
        schedule.setId(UUID.randomUUID().toString());
        schedule.setFlight(flight);
        schedule.setPilot(pilot);
        schedule.setJourneyStartDate(request.getJourneyStartDate());
        schedule.setSourceAirport(sourceAirport);
        schedule.setJourneyEndDate(request.getJourneyEndDate());
        schedule.setDestAirport(destAirport);
        schedule.setMaxTravellerCapacity(request.getMaxTravellerCapacity());
        schedule.setMaxWaitingCapacity(request.getMaxWaitingCapacity());
        schedule.setCreatedAt(LocalDateTime.now());
        schedule.setCreatedBy("SYSTEM");
        schedule.setLastUpdatedAt(LocalDateTime.now());
        schedule.setLastUpdatedBy("SYSTEM");


        flightScheduleRepository.save(schedule);

        return schedule;
    }
}
