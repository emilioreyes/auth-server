package com.emidev.auth_server.persistence.mapper.seguridad.helper;

import com.emidev.auth_server.domain.dto.seguridad.SegRolSimpleDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegUsuarioRolEntity;
import com.emidev.auth_server.persistence.mapper.seguridad.SegRolSimpleMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Ayuda a mapear los roles que pertenecen a un usuario.
 */
@Component
public class SegUsuarioMapperHelper {
    private final SegRolSimpleMapper segRolSimpleMapper;

    public SegUsuarioMapperHelper(SegRolSimpleMapper segRolSimpleMapper) {
        this.segRolSimpleMapper = segRolSimpleMapper;
    }
    public List<SegRolSimpleDTO> mapRoles(Set<SegUsuarioRolEntity> usuariosRoles) {
        if (usuariosRoles == null) return null;
        return usuariosRoles.stream()
                .map(ur -> ur.getRol())
                .distinct()
                .map(segRolSimpleMapper::toDto)
                .collect(Collectors.toList());
    }

}
