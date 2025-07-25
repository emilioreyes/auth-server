package com.emidev.auth_server.persistence.mapper.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegRolDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegRolEntity;
import com.emidev.auth_server.persistence.mapper.seguridad.helper.SegRolMapperHelper;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SegRolMapper{
    @Mappings({
            @Mapping(source = "rol", target = "rol"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(target= "users", expression = "java(segRolMapperHelper.mapUsers(rolEntity.getRolUsuario()))")
    })
    SegRolDTO toDto(SegRolEntity rolEntity,@Context SegRolMapperHelper segRolMapperHelper);

    List<SegRolDTO> toDtoList(List<SegRolEntity> rolEntities, @Context SegRolMapperHelper segRolMapperHelper);
    @InheritInverseConfiguration
    SegRolEntity toEntity(SegRolDTO rolDTO);

}
