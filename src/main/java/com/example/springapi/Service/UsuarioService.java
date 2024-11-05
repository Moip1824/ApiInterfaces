package com.example.springapi.Service;

import com.example.springapi.Entity.Usuarios;
import com.example.springapi.Entity.Viajes;
import com.example.springapi.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public List<Viajes> obtenerViajesPorUsuario(Integer idUsuario) {
        return usuarioRepository.findViajesByUsuarioId(idUsuario);
    }
    public List<Usuarios> obtenerAmigosPorUsuario(Integer idUsuario) {
        Usuarios usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuario.getAmigos();
    }
}

