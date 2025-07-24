package com.emidev.auth_server.domain.repository.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegRolDTO;
import com.emidev.auth_server.persistence.entity.seguridad.SegRolEntity;
import com.emidev.auth_server.persistence.repository.seguridad.SegRolRepository;

import java.util.List;

public interface SegRolRepositoryDomain {
   SegRolDTO save(SegRolDTO segRolDto);
   SegRolDTO update(SegRolDTO segRolDto, String rol);
   Boolean delete(String rolId);
   List<SegRolDTO> all();
}
