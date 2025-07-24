package com.emidev.auth_server.persistence.mapper.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioDTO;
import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioSimpleDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegUsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper (componentModel = "spring", uses = {SegPersonaSimpleMapper.class})
public interface SegUsuarioSimpleMapper {
    @Mappings({
            @Mapping(source = "usuario", target = "username"),
            @Mapping(source = "clave", target = "password"),
            @Mapping(source = "estado", target = "estate"),
            @Mapping(source = "persona", target = "person"),
    })
    SegUsuarioSimpleDTO toDto(SegUsuarioEntity usuarioEntity);
}
