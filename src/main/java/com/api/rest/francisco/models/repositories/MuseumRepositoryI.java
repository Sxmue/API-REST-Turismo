package com.api.rest.francisco.models.repositories;

import com.api.rest.francisco.models.Museum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuseumRepositoryI extends JpaRepository<Museum,Long> {

    public List<Museum> findAllByMunicipality(String municipality);
    public Museum findByName(String name);

    public List<Museum> findAllByPostcode(Integer postcode);

    public List<Museum> findAllByProvince(String province);

    @Query("SELECT m FROM Museum m WHERE m.unit_type = :type")
   public List<Museum> findAllByUnit_type(String type);
}
