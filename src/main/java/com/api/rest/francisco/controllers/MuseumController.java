package com.api.rest.francisco.controllers;


import com.api.rest.francisco.models.MuseumDTO;
import com.api.rest.francisco.services.museum.MuseumManagmentImpl;
import com.api.rest.francisco.services.security.SecurityServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/museos")
public class MuseumController {

    private final MuseumManagmentImpl museumManagment;

    private final SecurityServiceImpl securityService;


    @Autowired
    public MuseumController(MuseumManagmentImpl museumManagment, SecurityServiceImpl securityService) {
        this.museumManagment = museumManagment;
        this.securityService = securityService;
    }

    @GetMapping("/all/{token}")
    public ResponseEntity<List<MuseumDTO>> allMuseums(@PathVariable Integer token){

        ResponseEntity<List<MuseumDTO>> response = null;

        List<MuseumDTO> list = new ArrayList<>();

        if (Boolean.TRUE.equals(securityService.validateToken(token))){

             list = museumManagment.getAllMuseums();

             response = new ResponseEntity<>(list,HttpStatus.OK);

        }else{

            response = new ResponseEntity<>(list,HttpStatus.UNAUTHORIZED);

        }


        return response;

    }



}
