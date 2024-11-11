package com.example.insriptionn.entity;

import jakarta.persistence.*;

@Entity
public class InsEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIns;  // Utilisation de Long pour permettre les valeurs nulles

    @Column(name = "nom_event", nullable = false)
    private String nomEvent;

    @Column(name = "nom_participant", nullable = false)
    private String nomParticipant;

    @Column(name = "email_participant", nullable = false, unique = true)
    private String emailParticipant;

    // Constructeurs
    public InsEvent() {}

    public InsEvent(String nomEvent, String nomParticipant, String emailParticipant) {
        this.nomEvent = nomEvent;
        this.nomParticipant = nomParticipant;
        this.emailParticipant = emailParticipant;
    }

    // Getters et setters
    public Long getIdIns() {  // Utilisation de Long pour correspondre au type de la variable
        return idIns;
    }

    public void setIdIns(Long idIns) {
        this.idIns = idIns;
    }

    public String getNomEvent() {
        return nomEvent;
    }

    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
    }

    public String getNomParticipant() {
        return nomParticipant;
    }

    public void setNomParticipant(String nomParticipant) {
        this.nomParticipant = nomParticipant;
    }

    public String getEmailParticipant() {
        return emailParticipant;
    }

    public void setEmailParticipant(String emailParticipant) {
        this.emailParticipant = emailParticipant;
    }
}
