package com.ars.services;

import com.ars.entities.FlightSchedule;
import com.ars.model.request.FlightCreateUpdateReq;
import com.ars.model.request.FlightScheduleCreateUpdateReq;

public interface FlightScheduleService {

  FlightSchedule createFlightSchedule (FlightScheduleCreateUpdateReq flightScheduleCreateUpdateReq);
}
