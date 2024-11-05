package com.example.springapi.Repository;

import com.example.springapi.Entity.Propuestas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropuestasRepository extends JpaRepository<Propuestas, Integer> {
    Propuestas findById(int id);
}
