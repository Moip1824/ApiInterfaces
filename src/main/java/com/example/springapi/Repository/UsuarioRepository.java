package com.example.springapi.Repository;

import com.example.springapi.Entity.Usuarios;
import com.example.springapi.Entity.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
    @Query("SELECT u2 FROM Usuarios u1 JOIN u1.amigos u2 WHERE u1.id = :idUsuario")
    List<Usuarios> findAmigosByUsuarioId(@Param("idUsuario") Integer idUsuario);

    @Query("SELECT v FROM Viajes v JOIN v.participantes p WHERE p.id = :idUsuario")
    List<Viajes> findViajesByUsuarioId(@Param("idUsuario") Integer idUsuario);
}
