package com.agenceImmobilier.agenceWebSite.Agent;

import org.springframework.stereotype.Service;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository)
    {
        this.agentRepository = agentRepository;
    }
}
