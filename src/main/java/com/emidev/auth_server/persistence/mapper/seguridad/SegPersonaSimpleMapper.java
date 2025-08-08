package com.emidev.auth_server.persistence.mapper.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegPersonaSimpleDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegPersonaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface SegPersonaSimpleMapper {
    @Mappings({
            @Mapping(source = "identificacion", target = "identification"),
            @Mapping(source = "nombres", target = "names"),
            @Mapping(source = "apellido1", target = "lastname1"),
            @Mapping(source = "apellido2", target = "lastname2"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "estado", target = "state")
    })
    SegPersonaSimpleDTO toDto(SegPersonaEntity personaEntity);
}
