package com.ars.services;

import com.ars.entities.Pilot;
import com.ars.model.request.PilotCreateUpdateReq;

public interface PilotService {

    Pilot createPilot(PilotCreateUpdateReq pilotCreateUpdateReq);
}
