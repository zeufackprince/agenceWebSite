package com.agenceImmobilier.agenceWebSite.Belongings;

import java.util.List;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BelongingRepository extends JpaRepository<Belongings, Long>{

    List<Belongings> findByAgent(Agent agent);

    List<Belongings> findByType(String type);
}
