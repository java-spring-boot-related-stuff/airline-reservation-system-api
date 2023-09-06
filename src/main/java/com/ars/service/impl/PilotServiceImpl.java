package com.ars.service.impl;


import com.ars.entities.Pilot;
import com.ars.model.request.PilotCreateUpdateReq;
import com.ars.repository.PilotRepository;
import com.ars.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PilotServiceImpl implements PilotService {

    @Autowired
    private PilotRepository pilotRepository;

    @Override
    public Pilot createPilot(PilotCreateUpdateReq request) {

        Pilot pilot= new Pilot();
        pilot.setId(UUID.randomUUID().toString());
        pilot.setName(request.getName());
        pilot.setCreatedAt(LocalDateTime.now());
        pilot.setCreatedBy("SYSTEM");
        pilot.setLastUpdatedAt(LocalDateTime.now());
        pilot.setLastUpdatedBy("SYSTEM");

        pilotRepository.save(pilot);

        return pilot;
    }
}
