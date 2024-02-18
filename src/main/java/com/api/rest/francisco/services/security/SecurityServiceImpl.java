package com.api.rest.francisco.services.security;

import com.api.rest.francisco.models.User;
import com.api.rest.francisco.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * Servicio de Seguridad
 */
@Service
public class SecurityServiceImpl implements SecurityServiceI {


    private final UserServiceImpl userService;

    @Autowired
    public SecurityServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public Integer generateToken(User u) {

        User test = userService.isLogged(u);

        Integer token = null;

        if (test != null) {

            Random random = new Random();

            token = random.nextInt(Integer.MAX_VALUE) + 1;

            test.setToken(token);

            test.setModifyDate((new Date()));

            userService.updateUser(test);

        }

        return token;
    }

    @Override
    public Boolean validateToken(Integer token) {
        Boolean result = false;

        User u = userService.getUserByToken(token);

        Date now = new Date();

        if (u != null) {
            // Calcula la diferencia en milisegundos entre la fecha de modificación y la fecha actual
            long milisecondsDiference = now.getTime() - u.getModifyDate().getTime();

            // Convierte la diferencia a horas
            long houres = milisecondsDiference / (60 * 60 * 1000);

            if ((houres < 24) && Objects.equals(token, u.getToken())) {
                result = true;
            }
        }

        return result;
    }
}
