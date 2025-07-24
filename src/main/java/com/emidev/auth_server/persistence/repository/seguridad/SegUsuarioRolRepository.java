package com.emidev.auth_server.persistence.repository.seguridad;

import com.emidev.auth_server.persistence.entity.seguridad.SegUsuarioRolEntity;
import com.emidev.auth_server.persistence.entity.seguridad.SegUsuarioRolPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegUsuarioRolRepository extends JpaRepository<SegUsuarioRolEntity, SegUsuarioRolPk> {

    // Custom query methods can be added here if needed
}
