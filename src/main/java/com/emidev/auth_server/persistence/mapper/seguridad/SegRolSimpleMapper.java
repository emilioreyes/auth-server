package com.emidev.auth_server.persistence.mapper.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegRolDTO;
import com.emidev.auth_server.domain.dto.seguridad.SegRolSimpleDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegRolEntity;
import com.emidev.auth_server.persistence.mapper.seguridad.helper.SegRolMapperHelper;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SegRolSimpleMapper {
    @Mappings({
            @Mapping(source = "rol", target = "rol"),
            @Mapping(source = "descripcion", target = "description"),
    })
    SegRolSimpleDTO toDto(SegRolEntity rolEntity);

}
