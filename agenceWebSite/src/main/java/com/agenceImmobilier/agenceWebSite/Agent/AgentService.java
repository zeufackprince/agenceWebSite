package com.agenceImmobilier.agenceWebSite.Agent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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

    @Transactional
    public void updateAgents(Long id, String nom, String password, String numeroTelephone, byte[] imageProfil) {
        // Optional<Agents> agents = this.agentRepository.findById(id);

        // if (nom != null && nom.length() > 0 && !Objects.equals(agents.get)) {
            
        // }
        
    }
}
