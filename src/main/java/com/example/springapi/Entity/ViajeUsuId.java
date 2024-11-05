package com.example.springapi.Entity;
import java.io.Serializable;
import java.util.Objects;

public class ViajeUsuId implements Serializable {
    private Integer usuario;
    private Integer viaje;

    // Constructor vacío (requerido)
    public ViajeUsuId() {}

    public ViajeUsuId(Integer usuario, Integer viaje) {
        this.usuario = usuario;
        this.viaje = viaje;
    }

    // Implementar hashCode y equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ViajeUsuId)) return false;
        ViajeUsuId that = (ViajeUsuId) o;
        return Objects.equals(usuario, that.usuario) && Objects.equals(viaje, that.viaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, viaje);
    }
}
