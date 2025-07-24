package com.emidev.auth_server.persistence.entity.seguridad;

import com.emidev.auth_server.persistence.entity.PropiedadesComunesEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "seg_personas")
@NoArgsConstructor
@Where(clause = "estado IS NULL")
@Getter
@Setter
public class SegPersonaEntity extends PropiedadesComunesEntity {

    private String identificacion;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;

    @OneToOne(mappedBy = "persona",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JsonBackReference(value = "usuarioPersona")
    private SegUsuarioEntity usuario;
    @Override
    public String toString() {
        return "SegPersonaEntity{" +
                "cedula='" + identificacion + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
