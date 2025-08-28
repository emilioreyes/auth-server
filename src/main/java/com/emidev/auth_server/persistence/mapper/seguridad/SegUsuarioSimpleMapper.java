package com.emidev.auth_server.persistence.mapper.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioDTO;
import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioSimpleDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegUsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper (componentModel = "spring")
public interface SegUsuarioSimpleMapper {
    @Mappings({
            @Mapping(source = "usuario", target = "username"),
            @Mapping(source = "clave", target = "password"),
            @Mapping(source = "estado", target = "estate"),
    })
    SegUsuarioSimpleDTO toDto(SegUsuarioEntity usuarioEntity);
}
