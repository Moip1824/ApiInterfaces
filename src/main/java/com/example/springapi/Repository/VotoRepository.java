package com.example.springapi.Repository;

import com.example.springapi.Entity.Propuestas;
import com.example.springapi.Entity.Usuarios;
import com.example.springapi.Entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
    Optional<Voto> findByUsuarioAndPropuestas(Usuarios usuario, Propuestas propuestas);
}
