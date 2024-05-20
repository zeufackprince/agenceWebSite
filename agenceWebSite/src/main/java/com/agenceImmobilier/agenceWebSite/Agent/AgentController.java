package com.agenceImmobilier.agenceWebSite.Agent;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService)
    {
        this.agentService = agentService;
    }

    @PostMapping(path = "/register")
    public void newAgent(@RequestBody Agents agents)
    {
        this.agentService.createAgent(agents);
    }

    @GetMapping
    public List<Agents> getAgents()
    {
        return this.agentService.getAll();
    }

    @GetMapping(path = "/email" )
    public Agents getByEmail(@RequestBody String email)
    {
        return this.agentService.getAgents(email);
    }

    @GetMapping(path = "/nom")
    public Agents getByNomAgents(@RequestBody String nom)
    {
        return this.agentService.getByName(nom);
    }

    
}
