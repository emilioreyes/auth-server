package com.emidev.auth_server.persistence.entity.seguridad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "seg_usuarios_roles")
public class SegUsuarioRolEntity {
    @EmbeddedId
    private SegUsuarioRolPk id;
    @Column(name = "estado", length = 1)
    private String estado;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonBackReference(value = "usuarioRol")
    private SegUsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("rol")
    @JoinColumn(name = "rol", nullable = false)
    @JsonBackReference(value = "rolUsuario")
    private SegRolEntity rol;

}
