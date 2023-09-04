package com.ars.model.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AirportCreateUpdateReq {

    private String name;
    private String city;

}
