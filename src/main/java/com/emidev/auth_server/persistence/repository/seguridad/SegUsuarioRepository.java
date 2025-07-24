package com.emidev.auth_server.persistence.repository.seguridad;

import com.emidev.auth_server.persistence.entity.seguridad.SegUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface SegUsuarioRepository extends JpaRepository<SegUsuarioEntity, Long> {
    @Query("SELECT u FROM SegUsuarioEntity u WHERE u.usuario = :usuario")
    Optional<SegUsuarioEntity> findByUsername(@Param("usuario") String username);
}
