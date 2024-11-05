// src/main/java/com/example/springapi/Entity/Usuarios.java
package com.example.springapi.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 55)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 500)
    private String contraseña;

    @Column(length = 500)
    private String imagen;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Viajes> viajes;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "viaje-usu",
            joinColumns = @JoinColumn(name = "id-usuario"),
            inverseJoinColumns = @JoinColumn(name = "id-viajes")
    )
    private List<Viajes> viajeUsu;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "grupo-usu",
            joinColumns = @JoinColumn(name = "id-usuario"),
            inverseJoinColumns = @JoinColumn(name = "id-grupos")
    )
    private List<Grupos> grupoUsu;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "amigos",
            joinColumns = @JoinColumn(name = "id-usuario"),
            inverseJoinColumns = @JoinColumn(name = "id-usuario2")
    )
    private List<Usuarios> amigos;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "voto",
            joinColumns = @JoinColumn(name = "id-usuario"),
            inverseJoinColumns = @JoinColumn(name = "id-propuestas")
    )
    private List<Propuestas> votos;
}