package com.api.rest.francisco.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "museo")
public class Museum extends AbstractEntity implements Serializable {


    @Column(name = "nombre")
    private String name;
    @Column(name = "localizacion")
    private String location;
    @Column(name = "CodigoPostal")
    private Integer postcode;
    @Column(name = "latitud")
    private String latitude;
    @Column(name = "Municipio")
    private String municipality;
    @Column(name = "observaciones", length = 5000)
    private String observations;
    @Column(name = "direccion")
    private String address;
    @Column(name = "Horario", length = 2000)
    private String opening_hours;
    @Column(name = "Web")
    private String web;
    @Column(name = "Provincia")
    private String province;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "Tipo")
    private String unit_type;

}
