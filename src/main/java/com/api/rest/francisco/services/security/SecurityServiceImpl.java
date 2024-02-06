package com.api.rest.francisco.services.security;

import com.api.rest.francisco.models.User;
import com.api.rest.francisco.services.user.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Servicio de Seguridad
 */
@Service
public class SecurityServiceImpl implements SecurityServiceI{


    private final UserServiceImpl userService;

    @Autowired
    public SecurityServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public Integer generateToken(User u) {

        User test = userService.isLogged(u);

        Integer token = null;

        if (test != null){

            Random random = new Random();

            token = random.nextInt(Integer.MAX_VALUE) + 1;

        }
        //TODO HACER QUE EL TOKEN SE GUARDE EN LA BASE DE DATOS CON LA DATE ACTUAL
        return token;
    }

    @Override
    public Boolean validateToken(String token) {

        //TODO IMPLEMENTAR LA VALIDACION COGIENDO LA FECHA DEL USUARIO DE LA BASE DE DATOS Y HACIENDO TIMESTAMP

        return null;
    }
}
