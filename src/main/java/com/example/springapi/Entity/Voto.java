package com.example.springapi.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "voto")
@Getter
@Setter
public class Voto {

    @EmbeddedId
    private VotoId id;

    @ManyToOne
    @MapsId("usuario")
    @JoinColumn(name = "id-usuario")
    private Usuarios usuario;

    @ManyToOne
    @MapsId("propuestas")
    @JoinColumn(name = "id-propuestas")
    private Propuestas propuestas;

    @Column(name = "tipo-voto")
    private Boolean tipoVoto;

    protected Voto() {}

    public Voto(Usuarios usuario, Propuestas propuestas) {
        this.usuario = usuario;
        this.propuestas = propuestas;
        this.id = new VotoId(usuario.getId(), propuestas.getId());
    }
}