package com.emidev.auth_server.domain.repository.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegPersonaDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegPersonaEntity;
import com.emidev.auth_server.persistence.entity.seguridad.SegUsuarioEntity;

import java.util.List;

public interface SegPersonaRepositoryDomain {
    SegPersonaDTO save(SegPersonaDTO segPersonaDto);
    SegPersonaDTO update(SegPersonaDTO segPersonaDto, Long id);
    Boolean delete(String id);

    List<SegPersonaDTO> getAll();

    SegPersonaDTO getById(Long id);
}
