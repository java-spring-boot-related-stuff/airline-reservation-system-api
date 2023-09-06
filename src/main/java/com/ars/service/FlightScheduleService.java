package com.ars.service;

import com.ars.entities.FlightSchedule;
import com.ars.model.request.FlightScheduleCreateUpdateReq;

public interface FlightScheduleService {

    FlightSchedule createFlightSchedule(FlightScheduleCreateUpdateReq request);

}
