package com.api.rest.francisco.services.security;

import com.api.rest.francisco.models.User;




public interface SecurityServiceI {

    /** Servicio para la generacion de tokens */
    public Integer generateToken (User u);

    /** Servicio para la validacion de tokens */
    public Boolean validateToken(String token);


}
