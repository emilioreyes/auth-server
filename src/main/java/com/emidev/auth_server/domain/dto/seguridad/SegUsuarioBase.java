package com.emidev.auth_server.domain.dto.seguridad;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class SegUsuarioBase {
    private Long id;
    private String username;
    private String password;
    private String estate;
    //private SegPersonaSimpleDTO person;
}
