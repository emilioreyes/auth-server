package com.emidev.auth_server.persistence.entity.seguridad;

import com.emidev.auth_server.persistence.entity.PropiedadesComunesEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Set;

@Entity
@Table(name = "seg_usuarios")
@NoArgsConstructor
@Where(clause = "estado IS NULL")
@Getter @Setter
public class SegUsuarioEntity extends PropiedadesComunesEntity {

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "clave", nullable = false, length = 300)
    private String clave;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @Where(clause = "estado IS NULL")
    @JsonManagedReference(value = "usuarioRol")
    private Set<SegUsuarioRolEntity> usuarioRol;

}
