package com.api.rest.francisco.services;

import com.api.rest.francisco.models.Museum;
import com.api.rest.francisco.models.repositories.MuseumRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuseumManagmentImpl implements MuseumManagmentI{

    final MuseumRepositoryI museumRepository;

    @Autowired
    public MuseumManagmentImpl(MuseumRepositoryI museumRepository) {
        this.museumRepository = museumRepository;
    }

    @Override
    public void registerANewListMuseum(Iterable<Museum> m) {
        museumRepository.saveAll(m);

    }
}
