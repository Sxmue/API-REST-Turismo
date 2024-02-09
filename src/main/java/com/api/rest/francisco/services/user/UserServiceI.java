package com.api.rest.francisco.services.user;

import com.api.rest.francisco.models.User;

public interface UserServiceI {

    /** Metodo para loguear a un usuario */
    public User loginUser (String name, String dni,String email);

    /** Metodo para ver si un usuario esta loggeado */
    public User isLogged (User u);

    /** Metodo para actualizar un usuario */
    public User updateUser(User u);

    /** Metodo para buscar a un usuario por su token */
    public User getUserByToken(Integer token);

    /** Metodo para buscar a un usuario por su dni*/
    public User getUserBydni(String dni);

}
