package com.example.springapi.Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class VotoId implements Serializable {

    private Integer usuario;
    private Integer propuestas;

    public VotoId() {}

    public VotoId(Integer usuario, Integer propuestas) {
        this.usuario = usuario;
        this.propuestas = propuestas;
    }

    // Getters, setters, equals y hashCode
}