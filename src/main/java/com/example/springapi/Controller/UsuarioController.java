package com.example.springapi.Controller;

import com.example.springapi.Entity.Usuarios;
import com.example.springapi.Entity.Viajes;
import com.example.springapi.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/{idUsuario}/viajes")
    public ResponseEntity<List<Viajes>> obtenerViajesPorUsuario(@PathVariable Integer idUsuario) {
        List<Viajes> viajes = usuarioService.obtenerViajesPorUsuario(idUsuario);
        return ResponseEntity.ok(viajes);
    }
    @GetMapping("/{idUsuario}/amigos")
    public ResponseEntity<List<Usuarios>> obtenerAmigosPorUsuario(@PathVariable Integer idUsuario) {
        List<Usuarios> amigos = usuarioService.obtenerAmigosPorUsuario(idUsuario);
        return ResponseEntity.ok(amigos);
    }
}
