package com.emidev.auth_server.persistence.mapper.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegPersonaDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegPersonaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SegUsuarioSimpleMapper.class})
public interface SegPersonaMapper {

        @Mappings({
                @Mapping(source = "identificacion", target = "identification"),
                @Mapping(source = "nombres", target = "names"),
                @Mapping(source = "apellido1", target = "lastname1"),
                @Mapping(source = "apellido2", target = "lastname2"),
                @Mapping(source = "telefono", target = "phone"),
                @Mapping(source = "email", target = "email"),
                @Mapping(source = "estado", target = "state"),
                @Mapping(source ="usuario", target = "user")
        })
        SegPersonaDTO toDto(SegPersonaEntity personaEntity);

        List<SegPersonaDTO> toDtoList(List<SegPersonaEntity> personaEntities);

        @InheritInverseConfiguration
        @Mappings({
                @Mapping(target = "createdAt", ignore = true),
                @Mapping(target = "updatedAt", ignore = true)
        })
        SegPersonaEntity toEntity(SegPersonaDTO personaDTO);
}
