package com.ars.services.impl;

import com.ars.entities.FlightBooking;
import com.ars.entities.FlightSchedule;
import com.ars.exception.BadRequestException;
import com.ars.model.request.FlightBookingCreateReq;
import com.ars.repository.FlightBookingRepository;
import com.ars.repository.FlightScheduleRepository;
import com.ars.services.CreateUpdateBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreateUpdateBookiingImpl implements CreateUpdateBooking {

    @Autowired
    private FlightScheduleRepository flightScheduleRepository;

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    @Override
    public FlightBooking createBooking(FlightBookingCreateReq request) {


        FlightSchedule flightSchedule = flightScheduleRepository.findById(request.getScheduleId()).orElseThrow(() ->
                new BadRequestException("flight with id" + request.getScheduleId() + "does not exist"));

        FlightBooking flightBooking = new FlightBooking();
        flightBooking.setBookingId(UUID.randomUUID().toString());
        flightBooking.setCustomerName(request.getCustomerName());
        flightBooking.setFlightSchedule(flightSchedule);
        flightBooking.setAmountPaid(request.getAmountPaid());
        int currentStatus = getNewTicketStatus(flightSchedule);
        flightBooking.setCurrentStatus(currentStatus);
        flightBooking.setCreatedAt(LocalDateTime.now());
        flightBooking.setCreatedBy("System");
        flightBooking.setLastUpdatedAt(LocalDateTime.now());
        flightBooking.setLastUpdatedBy("system");
        flightBookingRepository.save(flightBooking);
        return flightBooking;


    }


    private int getNewTicketStatus(FlightSchedule schedule) {
        int confirmOrWaitingTicket = flightBookingRepository.countByFlightScheduleAndCurrentStatusNot(schedule, 2);
        if (confirmOrWaitingTicket < schedule.getMaxTravellerCapacity()) {
            return 1;
        }
        if (confirmOrWaitingTicket == schedule.getMaxTravellerCapacity() + schedule.getMaxWaitingCapacity()) {
            throw new BadRequestException("max ticket capacity reached");
        }
        return 0;
    }

    @Override
    public FlightBooking updateBooking(FlightBookingCreateReq req) {

        return null;
    }

    @Override
    public FlightBooking cancelBooking(String bookingId) {

        FlightBooking flightBooking = flightBookingRepository.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("booking id" + bookingId + "does not found"));

        if (flightBooking.getCurrentStatus() == 2) {
            throw new BadRequestException("booking id" + bookingId + "is alrady cancel");
        }


        int currentStatus = flightBooking.getCurrentStatus();
        flightBooking.setCurrentStatus(2);
        flightBookingRepository.save(flightBooking);
        return flightBooking;
    }


    private void confirmWaitingTicket(FlightSchedule schedule) {
        Optional<FlightBooking> firstWaitingTicket = flightBookingRepository.findFirstByFlightScheduleAndCurrentStatusOrderByCreatedAtAsc(schedule, 0);
        if (firstWaitingTicket.isEmpty()) {
            return;

        }

        FlightBooking flightBooking = firstWaitingTicket.get();
        flightBooking.setCurrentStatus(1);
        flightBookingRepository.save(flightBooking);


    }

}
