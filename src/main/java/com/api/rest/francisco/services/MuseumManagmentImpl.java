package com.api.rest.francisco.services;

import com.api.rest.francisco.models.Museum;
import com.api.rest.francisco.models.repositories.MuseumRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de gestion de museos
 */
@Service
public class MuseumManagmentImpl implements MuseumManagmentI{

    /** Inyeccion del repositorio*/
    final MuseumRepositoryI museumRepository;

    /**
     * Constructor de la clase
     * @param museumRepository repositorio de Spring
     */
    @Autowired
    public MuseumManagmentImpl(MuseumRepositoryI museumRepository) {
        this.museumRepository = museumRepository;
    }

    @Override
    public void registerANewListMuseum(Iterable<Museum> m) {
        museumRepository.saveAll(m);

    }

    @Override
    public List<Museum> getAllMuseums() {
        return museumRepository.findAll();
    }

    @Override
    public List<Museum> searchMuseumsByMunicipaly(String municipality) {
        return museumRepository.findAllByMunicipality(municipality);
    }

    @Override
    public Museum getMuseumByName(String name) {
        return museumRepository.findByName(name);
    }

    @Override
    public String getMuseumOpeningHoures(String name) {
        Museum m;
        m = museumRepository.findByName(name);
        return (m.getOpening_hours() != null) ? m.getOpening_hours() : "";
    }

    @Override
    public List<Museum> searchMuseumByProvince(String province) {
        return museumRepository.findAllByProvince(province);
    }

    @Override
    public List<Museum> searchMuseumByPostcode(Integer postcode) {
        return museumRepository.findAllByPostcode(postcode);
    }

    @Override
    public List<Museum> searchMuseumsByType(String type) {
        return museumRepository.findAllByUnit_type(type);
    }

    @Override
    public List<Museum> searchNearMuseums(Double latitud, Double longitud) {
        //TODO implementar este servicio
        return null;
    }

    @Override
    public Museum registerMuseum(Museum m) {
        return museumRepository.save(m);
    }

    @Override
    public Museum updateMuseum(Museum m) {
        return museumRepository.save(m);
    }

    @Override
    public Museum deleteMuseum(Museum m) {
        museumRepository.delete(m);
        return m;
    }
}
