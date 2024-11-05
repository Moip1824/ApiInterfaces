package com.example.springapi.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "mensajes")
public class Mensajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 1000)
    private String texto;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id-emisor")
    private Usuarios emisor;

    @ManyToOne
    @JoinColumn(name = "id-receptor")
    private Usuarios receptor;

    @ManyToOne
    @JoinColumn(name = "id-grupo")
    private Grupos grupo;
}