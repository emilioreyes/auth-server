package com.emidev.auth_server.persistence.mapper.seguridad.helper;

import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioDTO;
import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioSimpleDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegUsuarioRolEntity;
import com.emidev.auth_server.persistence.mapper.seguridad.SegUsuarioMapper;
import com.emidev.auth_server.persistence.mapper.seguridad.SegUsuarioSimpleMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Ayuda a mapear los usuarios que pertenecen a un rol.
 */
@Component
public class SegRolMapperHelper {

    private final SegUsuarioSimpleMapper segUsuarioSimpleMapper;

    public SegRolMapperHelper(SegUsuarioSimpleMapper segUsuarioSimpleMapper) {
        this.segUsuarioSimpleMapper = segUsuarioSimpleMapper;
    }

    public List<SegUsuarioSimpleDTO> mapUsers(Set<SegUsuarioRolEntity> usuariosRoles) {
        if (usuariosRoles == null) return null;
        return usuariosRoles.stream()
                .map(ur -> ur.getUsuario())
                .distinct()
                .map(segUsuarioSimpleMapper::toDto)
                .collect(Collectors.toList());
    }

   /* public SegUsuarioSimpleDTO mapUserToDto(SegUsuarioEntity user) {
        if (user == null) return null;
        SegUsuarioSimpleDTO dto = new SegUsuarioSimpleDTO();
        dto.setUsername(user.getUsuario());
        dto.setId(user.getId());
        dto.setEstate(user.getEstado());
        SegPersonaDTO personaDto = new SegPersonaDTO();
        personaDto.setId(user.getPersona().getId());
        personaDto.setNames(user.getPersona().getNombres());
        personaDto.setLastname1(user.getPersona().getApellido1());
        personaDto.setLastname2(user.getPersona().getApellido2());
        personaDto.setEmail(user.getPersona().getEmail());
        personaDto.setPhone(user.getPersona().getTelefono());
        personaDto.setIdentification(user.getPersona().getIdentificacion());
        dto.setPerson(personaDto);
        return dto;
    }*/
}
