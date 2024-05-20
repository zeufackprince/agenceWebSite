package com.agenceImmobilier.agenceWebSite.Agent;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AgentDetailService implements UserDetailsService{

    private final AgentRepository agentRepository;

    public AgentDetailService(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Agents> agent = Optional.of(agentRepository.findByNom(username));
        if (agent.isPresent()) {
            var object = agent.get();
            return User.builder()
                                    .username(object.getNom())
                                    .password(object.getPassword())
                                    .roles(getRoles(object))
                                    .build();
        }else{
            throw new UsernameNotFoundException(username);
        }
    }
    public String[] getRoles(Agents agents) {
        if (agents.getRole() == null) {
            return new String[]{"USER"};
        }
        return agents.getRole().split(",");
    }

}
