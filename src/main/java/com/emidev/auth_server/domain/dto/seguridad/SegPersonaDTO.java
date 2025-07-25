package com.emidev.auth_server.domain.dto.seguridad;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SegPersonaDTO extends SegPersonaBase {
    private SegUsuarioSimpleDTO user;
}
