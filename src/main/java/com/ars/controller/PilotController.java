package com.ars.controller;

import com.ars.entities.Pilot;
import com.ars.model.request.PilotCreateUpdateReq;
import com.ars.services.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pilot")
public class PilotController {

    @Autowired
    private PilotService pilotService;


    @PostMapping
    public Pilot onboardPilot(@RequestBody PilotCreateUpdateReq pilotCreateReq) {

        return pilotService.createPilot(pilotCreateReq);

    }

}
