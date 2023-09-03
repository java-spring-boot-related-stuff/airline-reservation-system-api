package com.ars.repository;

import com.ars.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository  extends JpaRepository<Flight, String> {
}
