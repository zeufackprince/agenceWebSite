package com.agenceImmobilier.agenceWebSite.Belongings;

import javax.management.relation.RelationNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenceImmobilier.agenceWebSite.Agent.AgentRepository;
import com.agenceImmobilier.agenceWebSite.Agent.Agents;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(path = "/api/belonging")
public class BelongingController {

    private final BelongingService belongingService;

    private final AgentRepository agentRepository;

    public BelongingController(BelongingService belongingService, AgentRepository agentRepository)
    {
        this.belongingService = belongingService;
        this.agentRepository = agentRepository;
    }

    @PostMapping
    public Belongings createBienImmobilier(@RequestBody Belongings bienImmobilier, String email) throws RelationNotFoundException {
        Agents agent = agentRepository.findByEmail(email);
        if (agent == null) {
            throw new EntityNotFoundException("Agent with id " + email + " not found");
        }
        return belongingService.createBienImmobilier(bienImmobilier, agent);
    }
}
