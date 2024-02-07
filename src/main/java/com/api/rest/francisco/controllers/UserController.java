package com.api.rest.francisco.controllers;

import com.api.rest.francisco.services.security.SecurityServiceImpl;
import com.api.rest.francisco.services.user.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserServiceImpl userService;

    private final SecurityServiceImpl securityService;

    @Autowired
    public UserController(UserServiceImpl userService, SecurityServiceImpl securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping("/login/{name}/{dni}/{email}")
    public ResponseEntity<Integer> login(@PathVariable @NotBlank String name, @PathVariable @NotBlank String dni, @PathVariable @NotBlank String email, HttpServletRequest request){

        ResponseEntity<Integer> response = null;

        if(!name.isEmpty() && !dni.isEmpty() && !email.isEmpty()){

            response = new ResponseEntity<>( (securityService.generateToken(userService.loginUser(name,dni,email))) , HttpStatus.OK);
            HttpSession s = request.getSession();
            s.setAttribute("token",response.getBody());

        }else{

            response = new ResponseEntity<>( null , HttpStatus.BAD_REQUEST);

        }
        return response;

    }
}
