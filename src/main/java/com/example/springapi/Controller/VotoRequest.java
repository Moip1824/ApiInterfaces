package com.example.springapi.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoRequest {
    private Integer idPropuesta;
    private Integer idUsuario;
    private Boolean tipoVoto;
}
