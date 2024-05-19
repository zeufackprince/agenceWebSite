package com.agenceImmobilier.agenceWebSite.Notification;

import java.time.LocalDateTime;

import com.agenceImmobilier.agenceWebSite.Agent.Agents;
import com.agenceImmobilier.agenceWebSite.Client.Clients;
import com.agenceImmobilier.agenceWebSite.Pubication.Publication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @OneToOne
    private Clients client;

    @OneToOne
    private Publication publication;

    @OneToOne
    private Agents agent;

    private LocalDateTime dateEnvoi;

    // Getters et setters...
}
