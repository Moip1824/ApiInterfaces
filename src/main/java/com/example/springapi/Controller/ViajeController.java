package com.example.springapi.Controller;

import com.example.springapi.Entity.Usuarios;
import com.example.springapi.Entity.Viajes;
import com.example.springapi.Repository.UsuarioRepository;
import com.example.springapi.Repository.ViajeRepository;
import com.example.springapi.Service.ViajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viajes")
@RequiredArgsConstructor
public class ViajeController {
    private final ViajeService viajeService;
    private final ViajeRepository viajeRepository;
    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Viajes> crearViaje(@RequestBody Viajes viajes){
        Viajes nViaje = viajeService.crearViaje(viajes);
        return ResponseEntity.status(HttpStatus.CREATED).body(nViaje);
    }
    @PostMapping("{idViaje}/participantes/{idUsuario}")    public ResponseEntity<Viajes> añadirParticipante(@PathVariable Integer idViaje, @PathVariable Integer idUsuario){
        System.out.println("ID Viaje: " + idViaje + ", ID Usuario: " + idUsuario);
        Viajes viaje = viajeService.añadirParticipante(idViaje, idUsuario);
        return ResponseEntity.ok(viaje);
    }

    @DeleteMapping("/{idViaje}/participantes/{idUsuario}")
    public ResponseEntity<Viajes> eliminarParticipante(@PathVariable Integer idViaje, @PathVariable Integer idUsuario){
        Viajes viaje = viajeService.eliminarParticipante(idViaje, idUsuario);
        return ResponseEntity.ok(viaje);
    }

    @GetMapping("/{idViaje}/participantes")
    public ResponseEntity<List<Usuarios>> obtenerParticipantesPorViaje(@PathVariable Integer idViaje) {
        List<Usuarios> participantes = viajeService.obtenerParticipantesPorViaje(idViaje);
        return ResponseEntity.ok(participantes);
    }
    @PostMapping("/votar")
    public ResponseEntity<Void> votarPropuesta(@RequestBody VotoRequest votoRequest) {
        viajeService.votarPropuesta(votoRequest.getIdPropuesta(), votoRequest.getIdUsuario(), votoRequest.getTipoVoto());
        return ResponseEntity.ok().build();
    }
}
