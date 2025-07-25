package com.emidev.auth_server.domain.service.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegPersonaDTO;
import com.emidev.auth_server.domain.repository.seguridad.SegPersonaRepositoryDomain;
import com.emidev.auth_server.persistence.entity.seguridad.SegPersonaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegPersonaService {
    private final SegPersonaRepositoryDomain segPersonaRepositoryDomain;

    public SegPersonaService(SegPersonaRepositoryDomain segPersonaRepositoryDomain) {
        this.segPersonaRepositoryDomain = segPersonaRepositoryDomain;
    }

    public SegPersonaDTO save(SegPersonaDTO segPersonaDto) {
        return segPersonaRepositoryDomain.save(segPersonaDto);
    }

    public SegPersonaDTO update(SegPersonaDTO segPersonaDto, Long id) {
        return segPersonaRepositoryDomain.update(segPersonaDto,id );
    }

    public List<SegPersonaDTO> getAll() {
        return segPersonaRepositoryDomain.getAll();
    }

    public SegPersonaDTO getById(Long id) {
        return segPersonaRepositoryDomain.getById(id);
    }
}
