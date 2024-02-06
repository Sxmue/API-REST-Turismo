package com.api.rest.francisco.services.museum;

import com.api.rest.francisco.models.Museum;
import com.api.rest.francisco.models.MuseumDTO;
import com.api.rest.francisco.models.repositories.MuseumRepositoryI;
import com.api.rest.francisco.services.DtoTransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de gestion de museos
 */
@Service
public class MuseumManagmentImpl implements MuseumManagmentI{

    /** Inyeccion del repositorio*/
    final MuseumRepositoryI museumRepository;

    /** Inyeccion del servicio*/
    final DtoTransformService dtoTransformService;

    /**
     * Constructor de la clase
     *s
     * @param museumRepository    repositorio de Spring
     * @param dtoTransformService servicio de transformacion de DTO
     */
    @Autowired
    public MuseumManagmentImpl(MuseumRepositoryI museumRepository, DtoTransformService dtoTransformService) {
        this.museumRepository = museumRepository;
        this.dtoTransformService = dtoTransformService;
    }

    @Override
    public void registerANewListMuseum(Iterable<Museum> m) {

        museumRepository.saveAll(m);

    }

    @Override
    public List<MuseumDTO> getAllMuseums() {

        List<MuseumDTO> list = new ArrayList<>();

        museumRepository.findAll().forEach(museum -> {
            list.add(dtoTransformService.museumToDto(museum));
        });

        return list ;
    }

    @Override
    public List<MuseumDTO> searchMuseumsByMunicipaly(String municipality) {

        List<MuseumDTO> list = new ArrayList<>();

        museumRepository.findAllByMunicipality(municipality).forEach(museum -> {
            list.add(dtoTransformService.museumToDto(museum));
        });

        return list ;
    }

    @Override
    public MuseumDTO getMuseumByName(String name) {
        return dtoTransformService.museumToDto(museumRepository.findByName(name));
    }

    @Override
    public String getMuseumOpeningHoures(String name) {
        Museum m;
        m = museumRepository.findByName(name);
        return (m.getOpening_hours() != null) ? m.getOpening_hours() : "";
    }

    @Override
    public List<MuseumDTO> searchMuseumByProvince(String province) {

        List<MuseumDTO> list = new ArrayList<>();

        museumRepository.findAllByProvince(province).forEach(museum -> list.add(dtoTransformService.museumToDto(museum)));

        return list ;
    }

    @Override
    public List<MuseumDTO> searchMuseumByPostcode(Integer postcode) {

        List<MuseumDTO> list = new ArrayList<>();

        museumRepository.findAllByPostcode(postcode).forEach(museum -> list.add(dtoTransformService.museumToDto(museum)));

        return list ;

    }

    @Override
    public List<MuseumDTO> searchMuseumsByType(String type) {

        List<MuseumDTO> list = new ArrayList<>();

        museumRepository.findAllByUnit_type(type).forEach(museum -> list.add(dtoTransformService.museumToDto(museum)));

        return list ;

    }

    @Override
    public List<MuseumDTO> searchNearMuseums(Double latitud, Double longitud){

        //TODO implementar este servicio

        return null;
    }

    @Override
    public MuseumDTO registerMuseum(MuseumDTO m) {

        Museum s = dtoTransformService.dtoToMuseum(m);

        return dtoTransformService.museumToDto(museumRepository.save(s));
    }

    @Override
    public MuseumDTO updateMuseum(MuseumDTO m) {

        Museum s = dtoTransformService.dtoToMuseum(m);

        return dtoTransformService.museumToDto(museumRepository.save(s));
    }

    @Override
    public MuseumDTO deleteMuseum(MuseumDTO m) {

        Museum s = dtoTransformService.dtoToMuseum(m);

        museumRepository.delete(s);

        return m;
    }
}
