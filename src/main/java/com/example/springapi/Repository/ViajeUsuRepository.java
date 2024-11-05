package com.example.springapi.Repository;

import com.example.springapi.Entity.Usuarios;
import com.example.springapi.Entity.ViajeUsu;
import com.example.springapi.Entity.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeUsuRepository extends JpaRepository<ViajeUsu, Integer> {
    void deleteByUsuarioAndViaje(Usuarios usuario, Viajes viaje);

}
