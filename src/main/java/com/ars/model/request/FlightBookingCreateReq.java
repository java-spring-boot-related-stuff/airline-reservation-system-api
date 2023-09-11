package com.ars.model.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FlightBookingCreateReq {


    private String scheduleId;

    private Integer amountPaid;

    private String customerName;

    private Integer currentStatus;
}
