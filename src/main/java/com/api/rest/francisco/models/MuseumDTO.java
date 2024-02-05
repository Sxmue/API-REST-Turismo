package com.api.rest.francisco.models;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Clase Data Transfer Object para Museo
 * @param name
 * @param location
 * @param postcode
 * @param latitude
 * @param municipality
 * @param observations
 * @param address
 * @param opening_hours
 * @param web
 * @param province
 * @param longitude
 * @param unit_type
 */
public record MuseumDTO(
        String name,
        String location,
        Integer postcode,
        String latitude,
        String municipality,
        String observations,
        String address,
        String opening_hours,
        String web,
        String province,
        String longitude,
        String unit_type

) {
}
