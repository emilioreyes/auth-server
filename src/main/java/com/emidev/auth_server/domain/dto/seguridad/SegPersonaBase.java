package com.emidev.auth_server.domain.dto.seguridad;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class SegPersonaBase {
    private Long id;
    private String identification;
    private String names;
    private String lastname1;
    private String lastname2;
    private String phone;
    private String email;
    private String state;
}
