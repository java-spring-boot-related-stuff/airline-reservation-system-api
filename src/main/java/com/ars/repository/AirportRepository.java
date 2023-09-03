package com.ars.repository;

import com.ars.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository  extends JpaRepository<Airport, String> {
}
