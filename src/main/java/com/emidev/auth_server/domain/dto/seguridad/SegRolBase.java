package com.emidev.auth_server.domain.dto.seguridad;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class SegRolBase {
    private String rol;
    private String description;
}
