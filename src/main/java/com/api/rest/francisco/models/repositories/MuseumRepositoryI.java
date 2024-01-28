package com.api.rest.francisco.models.repositories;

import com.api.rest.francisco.models.Museum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumRepositoryI extends JpaRepository<Museum,Long> {
}
