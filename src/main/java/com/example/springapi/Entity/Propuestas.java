package com.example.springapi.Entity;

import com.example.springapi.Entity.Usuarios;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "propuestas")
@Getter
@Setter
public class Propuestas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 1000)
    private String descripcion;

    @Column(length = 1000)
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "id-usuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id-grupo")
    private Grupos grupo;
    @JoinColumn(name = "aceptado")
    private Boolean aceptado;
    @JoinColumn(name = "titulo")
    private String titulo;

    @ManyToMany
    @JoinTable(
            name = "voto",
            joinColumns = @JoinColumn(name = "id-propuestas"),
            inverseJoinColumns = @JoinColumn(name = "id-usuario")
    )
    private List<Usuarios> usuariosVoto;
    public void addUsuarioVoto(Usuarios usuario) {
        if (!usuariosVoto.contains(usuario)) {
            usuariosVoto.add(usuario);
        }
    }

    public void removeUsuarioVoto(Usuarios usuario) {
        usuariosVoto.remove(usuario);
    }
}