package com.api.rest.francisco.services.user;

import com.api.rest.francisco.models.User;
import com.api.rest.francisco.models.repositories.UserRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {

    private final UserRepositoryI userRepositoryI;

    @Autowired
    public UserServiceImpl(UserRepositoryI userRepositoryI) {
        this.userRepositoryI = userRepositoryI;
    }


    @Override
    public User loginUser(String name, String dni) {
        User u = null;

        if (!name.isEmpty() && !dni.isEmpty()) {

           // u = new User(name, dni);

            userRepositoryI.save(u);

        }

        return u;
    }

    @Override
    public User isLogged(User u) {

        User r = null;

        Optional<User> f = userRepositoryI.findById(u.getId());

        if(f != null) {

            r = new User();
            r.setDni(f.get().getDni());
            r.setName(f.get().getDni());

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
}
