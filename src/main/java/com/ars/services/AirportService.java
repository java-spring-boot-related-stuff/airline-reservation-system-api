package com.ars.services;

import com.ars.entities.Airport;
import com.ars.model.request.AirportCreateUpdateReq;
import com.ars.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface AirportService {


  Airport createAirport(AirportCreateUpdateReq airportCreateUpdateReq);

}
