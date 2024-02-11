package com.api.rest.francisco.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Fecha de Guardado")
    private Date saveDate =  new Date();
    @Column(name = "Fecha de Modificacion")
    private Date modifyDate = new Date();
}
