package com.ars.services.impl;

import ch.qos.logback.core.util.Loader;
import com.ars.entities.Pilot;
import com.ars.model.request.PilotCreateUpdateReq;
import com.ars.repository.PilotRepository;
import com.ars.services.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;



@Service
public class PilotServiceImpl implements PilotService {

    @Autowired
    private PilotRepository pilotRepository;
    @Override
    public Pilot createPilot(PilotCreateUpdateReq req) {
        Pilot pilot=new Pilot();
        pilot.setId(UUID.randomUUID().toString());
        pilot.setName(req.getName());
        pilot.setCreatedAt(LocalDateTime.now());
        pilot.setCreatedBy("system");
        pilot.setLastUpdatedAt(LocalDateTime.now());
        pilot.setLastUpdatedBy("system");
        pilotRepository.save(pilot);
        return pilot;

    }
}
