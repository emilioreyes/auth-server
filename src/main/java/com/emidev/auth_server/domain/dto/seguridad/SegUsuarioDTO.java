package com.emidev.auth_server.domain.dto.seguridad;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SegUsuarioDTO extends SegUsuarioBase {
    private List<SegRolSimpleDTO> roles;
}
