package com.agenceImmobilier.agenceWebSite.Belongings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BelongingRepository extends JpaRepository<Belongings, Long>{

    // List<Belongings> findByAgent(Agents agents);

    List<Belongings> findByType(String type);
}
