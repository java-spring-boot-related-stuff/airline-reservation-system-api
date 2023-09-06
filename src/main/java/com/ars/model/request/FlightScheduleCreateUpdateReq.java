package com.ars.model.request;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class FlightScheduleCreateUpdateReq {

    private String flightId;
    private String pilotId;
    private LocalDateTime journeyStartDate;
    private String sourceAirportId;
    private LocalDateTime journeyEndDate;
    private String destAirportId;
    private Integer maxTravellerCapacity;
    private Integer maxWaitingCapacity;

}
