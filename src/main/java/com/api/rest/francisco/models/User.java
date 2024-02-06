package com.api.rest.francisco.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity implements Serializable {

    private String name;

    private String dni;

    private Integer token;

    //TODO AÑADIR CAMPO DE FECHA DE MODIFICACION MODIFICACION DEL REGISTRO EN EL ABSTRACT ENTITY
    private Date date;

}
