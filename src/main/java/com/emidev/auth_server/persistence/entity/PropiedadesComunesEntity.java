package com.emidev.auth_server.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class PropiedadesComunesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado", length = 1)
    private String estado; // null representa activo, 'X' eliminado

    @Column(name = "created_at",insertable = true)
    private java.time.LocalDateTime createdAt;

    @Column(name = "updated_at" ,updatable = true, nullable = true)
    private java.time.LocalDateTime updatedAt;
    @PrePersist
    private void prePersisrt() {
        if (estado != null && !estado.equals("X")) {
            throw new IllegalArgumentException("Estado debe ser 'X' or NULL");
        }
        this.createdAt = java.time.LocalDateTime.now();
    }
    @PreUpdate
    private void preUpdate() {
        if (estado != null && !estado.equals("X")) {
            throw new IllegalArgumentException("Estado debe ser 'X' or NULL");
        }
        this.updatedAt = java.time.LocalDateTime.now();
    }
}
