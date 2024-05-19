package com.agenceImmobilier.agenceWebSite.Agent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService)
    {
        this.agentService = agentService;
    }

}
