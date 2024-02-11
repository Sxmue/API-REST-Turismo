package com.api.rest.francisco.services;

import com.api.rest.francisco.models.Museum;
import com.api.rest.francisco.models.MuseumDTO;
import jakarta.persistence.Column;
import org.springframework.stereotype.Service;

/**
 * Servicio para la gestion los DTO
 */
@Service
public class DtoTransformService {

    /**
     * metodo para transformar un DTO en un objeto museo
     * @param m el dto que recibe
     * @return el museo que devuelve
     */
    public Museum dtoToMuseum(MuseumDTO m){

        Museum transformed = new Museum();

        if(m != null) {

            if(m.address() != null) {
                transformed.setAddress(m.address());
            }

            if(m.name() != null ) {
                transformed.setName(m.name());
            }

            if( m.latitude() != null) {
                transformed.setLatitude(m.latitude());
            }

            if( m.longitude() != null ) {
                transformed.setLongitude(m.longitude());
            }

            if(m.municipality() != null ) {
                transformed.setMunicipality(m.municipality());
            }

            if(m.location() != null) {

                transformed.setLocation(m.location());

            }

            if(m.observations() != null ) {
                transformed.setObservations(m.observations());
            }

            if(m.postcode() != null) {
                transformed.setPostcode(m.postcode());
            }

            if(m.opening_hours() != null) {
                transformed.setOpening_hours(m.opening_hours());
            }

            if(m.web() != null ) {
                transformed.setWeb(m.web());
            }

            if(m.province() != null) {
                transformed.setProvince(m.province());
            }

            if(m.unit_type() != null) {
                transformed.setUnit_type(m.unit_type());
            }

        }

         return transformed;

    }

    /**
     * Metodo para crear un dto de un objeto museo
     * @param m museo que recibe
     * @return dto creado
     */
    public MuseumDTO museumToDto(Museum m){
        return new MuseumDTO(
                m.getName(),
                m.getLocation(),
                m.getPostcode(),
                m.getLatitude(),
                m.getMunicipality(),
                m.getObservations(),
                m.getAddress(),
                m.getOpening_hours(),
                m.getWeb(),
                m.getProvince(),
                m.getLongitude(),
                m.getUnit_type()
        );

    }

}
