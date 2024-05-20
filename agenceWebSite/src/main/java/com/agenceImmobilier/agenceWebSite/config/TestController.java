package com.agenceImmobilier.agenceWebSite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenceImmobilier.agenceWebSite.Agent.AgentRepository;
import com.agenceImmobilier.agenceWebSite.Agent.Agents;

@RestController
@RequestMapping(path = "/")
public class TestController {


    @GetMapping(path = "home")
    public String welcome()
    {
        return "home";
    }

    @GetMapping(path = "admin/home")
    public String welcomeadmin()
    {
        return "home admin";
    }

    @GetMapping(path = "user/home")
    public String welcomeuser()
    {
        return "home user";
    }

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(path =  "user")
    public Agents createAgents(@RequestBody Agents agents)
    {
        agents.setPassword(passwordEncoder.encode(agents.getPassword()));
        return agentRepository.save(agents);
    }

}
