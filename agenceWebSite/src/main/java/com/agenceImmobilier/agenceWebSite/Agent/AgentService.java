package com.agenceImmobilier.agenceWebSite.Agent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AgentService(AgentRepository agentRepository)
    {
        this.agentRepository = agentRepository;
        
    }

    public void createAgent(Agents agents) {
        
        agents.setPassword(passwordEncoder.encode(agents.getPassword()));
        this.agentRepository.save(agents);
    }

    public List<Agents> getAll()

    {
        return agentRepository.findAll();
    }

    public Agents getAgents(String email)
    {
        return this.agentRepository.findByEmail(email);
    }

    public Agents getByName(String nom)
    {
        return this.agentRepository.findByNom(nom);
    }
}
