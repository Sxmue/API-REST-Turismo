package com.api.rest.francisco.services.user;

import com.api.rest.francisco.models.User;
import com.api.rest.francisco.models.repositories.UserRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio de gestion de usuarios
 */
@Service
public class UserServiceImpl implements UserServiceI {

    /** Inyeccion de repositorio */
    private final UserRepositoryI userRepositoryI;

    @Autowired
    public UserServiceImpl(UserRepositoryI userRepositoryI) {
        this.userRepositoryI = userRepositoryI;
    }


    @Override
    public User loginUser(String name, String dni,String email) {
        User u = null;

        if (!name.isEmpty() && !dni.isEmpty() && !email.isEmpty()) {

           u = new User();

           u.setEmail(email);
           u.setDni(dni);
           u.setName(name);

            userRepositoryI.save(u);

        }

        return u;
    }

    @Override
    public User isLogged(User u) {

        User r = null;

        Optional<User> f = userRepositoryI.findById(u.getId());

        if(f.isPresent()) {

            r = new User();
            r.setId(f.get().getId());
            r.setDni(f.get().getDni());
            r.setName(f.get().getName());
            r.setEmail(f.get().getEmail());
            r.setToken(f.get().getToken());
            r.setModifyDate(f.get().getModifyDate());
            r.setSaveDate(f.get().getSaveDate());

        }

        return r;
    }

    @Override
    public User updateUser(User u) {
        return userRepositoryI.save(u);
    }

    @Override
    public User getUserByToken(Integer token) {
        return userRepositoryI.findByToken(token);
    }

    @Override
    public User getUserBydni(String dni) {
        return userRepositoryI.findByDni(dni);
    }
}
