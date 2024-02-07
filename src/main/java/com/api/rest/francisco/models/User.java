package com.api.rest.francisco.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;


@Entity
@Table(name="Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity implements Serializable {

    @Column(name="nombre")
    private String name;

    @Column(name="DNI")
    private String dni;

    private String email;

    @Column(name="clave")
    private Integer token;


}
