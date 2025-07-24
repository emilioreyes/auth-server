package com.emidev.auth_server.persistence.repository.seguridad;

import com.emidev.auth_server.persistence.entity.seguridad.SegRolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface SegRolRepository extends JpaRepository<SegRolEntity, String> {

    // No additional methods needed, as the basic CRUD operations are provided by CrudRepository
    // You can add custom query methods if necessary
   @Query(value = "SELECT r FROM SegRolEntity r "+
                  "LEFT JOIN FETCH r.rolUsuario ru "+
                  "LEFT JOIN FETCH ru.usuario " +
                  "WHERE r.estado IS NULL")
    Optional<List<SegRolEntity>> findAllWithUsers();
}
