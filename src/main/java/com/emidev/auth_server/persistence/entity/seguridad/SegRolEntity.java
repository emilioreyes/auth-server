package com.emidev.auth_server.persistence.entity.seguridad;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seg_roles")
@NoArgsConstructor
@Where(clause = "estado IS NULL")
@Getter @Setter
public class SegRolEntity {
    @Id
    @Column(name = "rol", nullable = false, length = 50)
    private String rol;
    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;
    @Column(name = "estado", length = 1)
    private String estado;//null representa activo, 'X' eliminado
    @PrePersist
    @PreUpdate
    private void validateEstado() {
        if (estado != null && !estado.equals("X")) {
            throw new IllegalArgumentException("Estado debe ser 'X' or NULL");
        }
    }

    @OneToMany(mappedBy = "rol", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Where(clause = "estado IS NULL")
    @JsonManagedReference(value = "rolUsuario")
    private Set<SegUsuarioRolEntity> rolUsuario;

}
