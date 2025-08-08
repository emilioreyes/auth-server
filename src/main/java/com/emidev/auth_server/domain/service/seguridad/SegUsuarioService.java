package com.emidev.auth_server.domain.service.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioDTO;
import com.emidev.auth_server.domain.repository.seguridad.SegUsuarioRepositoryDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegUsuarioService {

    private final SegUsuarioRepositoryDomain segUsuarioRepository;

    public SegUsuarioService(SegUsuarioRepositoryDomain segUsuarioRepository) {
        this.segUsuarioRepository = segUsuarioRepository;
    }

    public SegUsuarioDTO getByUsername(String username) {
        return segUsuarioRepository.getByUsername(username);
    }
}
