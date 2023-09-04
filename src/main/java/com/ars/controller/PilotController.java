package com.ars.controller;

import com.ars.model.request.PilotCreateUpdateReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pilot")
public class PilotController {

    @PostMapping
    public Object onboardPilot(@RequestBody PilotCreateUpdateReq pilotCreateReq) {
        return null;
    }

}
