package com.agenceImmobilier.agenceWebSite.Belongings;

import org.springframework.stereotype.Service;

import com.agenceImmobilier.agenceWebSite.Agent.AgentRepository;
import com.agenceImmobilier.agenceWebSite.Agent.Agents;

@Service
public class BelongingService {

    private final BelongingRepository belongingRepository;

    private final AgentRepository agentRepository;

    public BelongingService(BelongingRepository belongingRepository, AgentRepository agentRepository)
    {
        this.belongingRepository = belongingRepository;
        this.agentRepository = agentRepository;
    }

    public Belongings createBienImmobilier(Belongings bienImmobilier, Agents agent) {
        bienImmobilier.setAgents(agent);
        return belongingRepository.save(bienImmobilier);
    }

}
