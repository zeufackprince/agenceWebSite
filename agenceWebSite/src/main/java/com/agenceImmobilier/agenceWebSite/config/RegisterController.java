package com.agenceImmobilier.agenceWebSite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agenceImmobilier.agenceWebSite.Agent.AgentRepository;
import com.agenceImmobilier.agenceWebSite.Agent.Agents;

@RestController
public class RegisterController {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register/user")
    public Agents createAgents(@RequestBody Agents agents)
    {
        agents.setPassword(passwordEncoder.encode(agents.getPassword()));
        return agentRepository.save(agents);
    }

}
