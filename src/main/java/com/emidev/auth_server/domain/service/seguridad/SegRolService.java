package com.emidev.auth_server.domain.service.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegRolDTO;
import com.emidev.auth_server.domain.repository.seguridad.SegRolRepositoryDomain;
import com.emidev.auth_server.persistence.entity.seguridad.SegRolEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegRolService {
    private final SegRolRepositoryDomain segRolRepository;

    public SegRolService(SegRolRepositoryDomain segRolRepository) {
        this.segRolRepository = segRolRepository;
    }
    public SegRolDTO save(SegRolDTO rolDto) {
        return segRolRepository.save(rolDto);
    }
    public SegRolDTO update(SegRolDTO rolDto, String rol) {
        return segRolRepository.update(rolDto,rol);
    }

    public Boolean delete(String rolId) {
        return segRolRepository.delete(rolId);
    }
    public List<SegRolDTO> all() {
        return segRolRepository.all();
    }
}
