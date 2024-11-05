package com.example.springapi.Service;

import com.example.springapi.Entity.*;
import com.example.springapi.Repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ViajeService {
    private final UsuarioRepository usuarioRepository;
    private final ViajeRepository viajeRepository;
    private final ViajeUsuRepository viajeUsuRepository;
    private final PropuestasRepository propuestaRepository;
    private final VotoRepository votoRepository;
    public Viajes crearViaje(Viajes viaje){
        return viajeRepository.save(viaje);
    }
    public Viajes añadirParticipante(Integer idViaje, Integer idUsuario){
        Viajes viaje = viajeRepository.findById(idViaje).orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
        Usuarios usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        viaje.getParticipantes().add(usuario);
        Viajes viajeGuardado = viajeRepository.save(viaje);
        viajeUsuRepository.save(new ViajeUsu(usuario, viajeGuardado));
        return viajeGuardado;
    }
    @Transactional
    public Viajes eliminarParticipante(Integer idViaje, Integer idUsuario) {
        Viajes viaje = viajeRepository.findById(idViaje).orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
        Usuarios usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        viaje.getParticipantes().remove(usuario);
        viajeUsuRepository.deleteByUsuarioAndViaje(usuario, viaje);
        return viajeRepository.save(viaje);
    }
    public List<Usuarios> obtenerAmigosPorUsuario(Integer idUsuario) {
        Usuarios usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuario.getAmigos();
    }
    public List<Usuarios> obtenerParticipantesPorViaje(Integer idViaje) {
        return viajeRepository.findById(idViaje)
                .map(Viajes::getParticipantes)
                .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
    }

    @Transactional
    public void votarPropuesta(Integer idPropuesta, Integer idUsuario, boolean tipoVoto) {
        Propuestas propuesta = propuestaRepository.findById(idPropuesta)
                .orElseThrow(() -> new RuntimeException("Propuesta no encontrada"));
        Usuarios usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Voto voto = votoRepository.findByUsuarioAndPropuestas(usuario, propuesta)
                .orElse(new Voto(usuario, propuesta));

        voto.setTipoVoto(tipoVoto);
        votoRepository.save(voto);
    }

}
