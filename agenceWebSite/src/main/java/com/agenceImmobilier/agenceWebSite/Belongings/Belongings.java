package com.agenceImmobilier.agenceWebSite.Belongings;

import java.util.List;

import com.agenceImmobilier.agenceWebSite.Agent.Agents;
// import com.agenceImmobilier.agenceWebSite.Pubication.Publication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class Belongings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String type;

    private double dimension;

    private String localisation;

    private double prix;
    
    @Lob
    private List<byte[]> images;

    // @OneToOne(mappedBy = "bienImmobilier")
    // private Publication publications;

    @ManyToOne
    private Agents agents;
}
