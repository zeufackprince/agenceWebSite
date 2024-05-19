package com.agenceImmobilier.agenceWebSite.Agent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agents, Long>{
    
    Agents findByEmail(String email);

}
