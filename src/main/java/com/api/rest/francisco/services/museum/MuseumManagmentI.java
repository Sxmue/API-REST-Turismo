package com.api.rest.francisco.services.museum;

import com.api.rest.francisco.models.Museum;
import com.api.rest.francisco.models.MuseumDTO;

import java.util.List;

public interface MuseumManagmentI {

    /** Metodo para inicializar la bbdd leyendo el JSON*/
    public void registerANewListMuseum(Iterable<Museum> m);


    /**
     * Servicio que obtiene todos los museos
     * @return Lista con los museos encontrados
     */
    public List<MuseumDTO> getAllMuseums();

    /**
     * Servicio que busca museos por municipio
     * @param municipality nombre del municipios
     * @return lista de museos en ese municipio
     */
    public List<MuseumDTO> searchMuseumsByMunicipaly(String municipality);

    /**
     * Servicio que obtiene todos los
     * @param name nombre del museo
     * @return el museo con todos los datos
     */
    public MuseumDTO getMuseumByName(String name);

    /**
     * Servicio que devuelve el horario de un museo
     * @param name nombre del museo
     * @return Horario del museo
     */
    public String getMuseumOpeningHoures(String name);

    /**
     * Servicio que busca museos por Provincia
     * @param province provincia en la que buscar
     * @return lista con los museos en la provincia
     */
    public List<MuseumDTO> searchMuseumByProvince(String province);

    /**
     * Servicio que busca museos por codigoPostal
     * @param postcode codigo postal
     * @return lista con los museos encontrados
     */
    public List<MuseumDTO> searchMuseumByPostcode(Integer postcode);

    /**
     * Servicio que busca museos por tipo de museo
     * @param type el tipo del museo
     * @return lista con los museos buscados
     */
    public List<MuseumDTO> searchMuseumsByType(String type);

    /**
     * Servicio que busca museos cercanos al usuario
     * @param latitud latitud del usuario
     * @param longitud longitud del usuario
     * @return lista de museos disponibles en ese rango
     */
    public List<MuseumDTO> searchNearMuseums(Double latitud,Double longitud);

    /**
     * Servicio para dar de alta un museo
     * @param m museo a registrar
     * @return museo dado de alta
     */
    public MuseumDTO registerMuseum(MuseumDTO m);

    /**
     * Servicio que actualiza un museo
     * @param m museo a actualizar
     * @return el museo actualizado
     */
    public MuseumDTO updateMuseum(MuseumDTO m);

    /**
     * Servicio que elimina un museo
     * @param m museo a eliminar
     * @return el museo eliminado
     */
    public MuseumDTO deleteMuseum(MuseumDTO m);







}
