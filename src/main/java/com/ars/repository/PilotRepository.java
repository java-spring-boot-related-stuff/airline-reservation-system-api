package com.ars.repository;

import com.ars.entities.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotRepository extends JpaRepository<Pilot, String> {
}
