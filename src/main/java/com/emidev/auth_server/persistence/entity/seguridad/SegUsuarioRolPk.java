package com.emidev.auth_server.persistence.entity.seguridad;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter
public class SegUsuarioRolPk implements Serializable {
    @Column(name = "id_usuario")
    private Long idUsuario;

    private String rol;
}
