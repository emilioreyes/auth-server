package com.emidev.auth_server.domain.repository.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioDTO;

import java.util.List;

public interface SegUsuarioRepositoryDomain {

    // Define methods for user repository operations
    // For example:
     SegUsuarioDTO save(SegUsuarioDTO user);
     SegUsuarioDTO update(SegUsuarioDTO user, Long id);
     Boolean delete(Long userId);
     List<SegUsuarioDTO> getAll();
     SegUsuarioDTO getByUsername(String username);
}
