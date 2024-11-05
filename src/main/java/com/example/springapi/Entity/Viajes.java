// src/main/java/com/example/springapi/Entity/Viajes.java
package com.example.springapi.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "viajes")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Viajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 70)
    private String ubicación;

    @Column(length = 100)
    private String titulo;

    private Date fecha;

    private Time hora;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id-usuario")
    private Usuarios usuario;

    @JsonIgnore
    @ManyToMany(mappedBy = "viajeUsu")
    private List<Usuarios> participantes;
}