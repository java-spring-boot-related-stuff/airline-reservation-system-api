package com.ars.service;

import com.ars.entities.Pilot;
import com.ars.model.request.PilotCreateUpdateReq;

public interface PilotService {

    Pilot createPilot(PilotCreateUpdateReq request);

}
