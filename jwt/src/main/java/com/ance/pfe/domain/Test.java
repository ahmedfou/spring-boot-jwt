package com.ance.pfe.domain;

import javax.persistence.*;

@Entity
@Table(name="Test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Type")
    private String type;

    @Column(name = "numero_port")
    private String numeroPort;

    @Column(name = "base")
    private String base;
    @Column(name = "nom_serveur")
    private String nomServeur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumeroPort() {
        return numeroPort;
    }

    public void setNumeroPort(String numeroPort) {
        this.numeroPort = numeroPort;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getNomServeur() {
        return nomServeur;
    }

    public void setNomServeur(String nomServeur) {
        this.nomServeur = nomServeur;
    }}

