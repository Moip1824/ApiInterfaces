package com.example.springapi.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@IdClass(ViajeUsuId.class)
@Table(name = "viaje-usu")
@Getter
@Setter
public class ViajeUsu {

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id-usuario")
    private Usuarios usuario;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id-viajes")
    private Viajes viaje;

    public ViajeUsu() {}

    // Constructor que acepta objetos completos
    public ViajeUsu(Usuarios usuario, Viajes viaje) {
        this.usuario = usuario;
        this.viaje = viaje;
    }

}