package com.emidev.auth_server.persistence.mapper.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegUsuarioEntity;
import com.emidev.auth_server.persistence.mapper.seguridad.helper.SegUsuarioMapperHelper;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SegUsuarioMapper {
    @Mappings({
            @Mapping(source = "usuario", target = "username"),
            @Mapping(source = "clave", target = "password"),
            @Mapping(source = "estado", target = "estate"),
            @Mapping(target = "roles", expression = "java(segUsuarioMapperHelper.mapRoles(usuarioEntity.getUsuarioRol()))")
    })
    SegUsuarioDTO toDto(SegUsuarioEntity usuarioEntity, @Context SegUsuarioMapperHelper segUsuarioMapperHelper);

    List<SegUsuarioDTO> toDtoList(List<SegUsuarioEntity> usuarioEntities, @Context SegUsuarioMapperHelper segUsuarioMapperHelper);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    SegUsuarioEntity toEntity(SegUsuarioDTO usuarioDTO);
}
