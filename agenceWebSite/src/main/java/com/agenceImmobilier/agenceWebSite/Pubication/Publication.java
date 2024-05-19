package com.agenceImmobilier.agenceWebSite.Pubication;

import java.util.List;

import com.agenceImmobilier.agenceWebSite.Agent.Agents;
import com.agenceImmobilier.agenceWebSite.Belongings.Belongings;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    @Lob
    private List<byte[]> images;

    @OneToOne
    @MapsId
    private Belongings bienImmobilier;

    @OneToOne
    private Agents agent;
}
