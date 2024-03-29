package com.api.rest.francisco.models.repositories;

import com.api.rest.francisco.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryI extends JpaRepository<User,Long> {


    public User findByToken(Integer token);

    public User findByDni(String dni);
}
