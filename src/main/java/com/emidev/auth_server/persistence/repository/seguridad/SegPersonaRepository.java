package com.emidev.auth_server.persistence.repository.seguridad;

import com.emidev.auth_server.persistence.entity.seguridad.SegPersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegPersonaRepository extends JpaRepository<SegPersonaEntity, Long> {
}
