package com.api.rest.francisco.controllers;


import com.api.rest.francisco.models.MuseumDTO;
import com.api.rest.francisco.services.museum.MuseumManagmentImpl;
import com.api.rest.francisco.services.security.SecurityServiceImpl;
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


    @GetMapping("/byMucipality/{mucipality}/{token}")
    public ResponseEntity<List<MuseumDTO>> getMuseumsByMucipality(@PathVariable String mucipality,@PathVariable Integer token){
        ResponseEntity<List<MuseumDTO>> response = null;

        List<MuseumDTO> list = new ArrayList<>();

        if (Boolean.TRUE.equals(securityService.validateToken(token))){

            list = museumManagment.searchMuseumsByMunicipaly(mucipality);


            response = new ResponseEntity<>(list,HttpStatus.OK);

        }else{

            response = new ResponseEntity<>(list,HttpStatus.UNAUTHORIZED);

        }

        return response;
    }

    @GetMapping("/byName/{name}/{token}")
    public ResponseEntity<MuseumDTO> getMuseumByName(@PathVariable String name,@PathVariable Integer token){
        ResponseEntity<MuseumDTO> response = null;

        MuseumDTO m = null;

        if (Boolean.TRUE.equals(securityService.validateToken(token))){

            m = museumManagment.getMuseumByName(name);


            response = new ResponseEntity<>(m,HttpStatus.OK);

        }else{

            response = new ResponseEntity<>(m,HttpStatus.UNAUTHORIZED);

        }

        return response;
    }

    @GetMapping("/byProvince/{province}/{token}")
    public ResponseEntity<List<MuseumDTO>> getMuseumsByProvince(@PathVariable String province,@PathVariable Integer token){
        ResponseEntity<List<MuseumDTO>> response = null;

        List<MuseumDTO> list = new ArrayList<>();

        if (Boolean.TRUE.equals(securityService.validateToken(token))){

            list = museumManagment.searchMuseumByProvince(province);


            response = new ResponseEntity<>(list,HttpStatus.OK);

        }else{

            response = new ResponseEntity<>(list,HttpStatus.UNAUTHORIZED);

        }

        return response;
    }


    @GetMapping("/byPostcode/{postcode}/{token}")
    public ResponseEntity<List<MuseumDTO>> getMuseumsByPostcode(@PathVariable Integer postcode,@PathVariable Integer token){
        ResponseEntity<List<MuseumDTO>> response = null;

        List<MuseumDTO> list = new ArrayList<>();

        if (Boolean.TRUE.equals(securityService.validateToken(token))){

            list = museumManagment.searchMuseumByPostcode(postcode);


            response = new ResponseEntity<>(list,HttpStatus.OK);

        }else{

            response = new ResponseEntity<>(list,HttpStatus.UNAUTHORIZED);

        }

        return response;
    }

    @GetMapping("/byType/{type}/{token}")
    public ResponseEntity<List<MuseumDTO>> getMuseumsByType(@PathVariable String type,@PathVariable Integer token){
        ResponseEntity<List<MuseumDTO>> response = null;

        List<MuseumDTO> list = new ArrayList<>();

        if (Boolean.TRUE.equals(securityService.validateToken(token))){

            list = museumManagment.searchMuseumsByType(type);


            response = new ResponseEntity<>(list,HttpStatus.OK);

        }else{

            response = new ResponseEntity<>(list,HttpStatus.UNAUTHORIZED);

        }

        return response;
    }


    @GetMapping("/near/{latitude}/{longitude}/{token}")
    public ResponseEntity<List<MuseumDTO>> getNearMuseums(@PathVariable Double latitude,@PathVariable Double longitude,@PathVariable Integer token){
        ResponseEntity<List<MuseumDTO>> response = null;

        List<MuseumDTO> list = new ArrayList<>();

        if (Boolean.TRUE.equals(securityService.validateToken(token))){

            list = museumManagment.searchNearMuseums(latitude,longitude);


            response = new ResponseEntity<>(list,HttpStatus.OK);

        }else{

            response = new ResponseEntity<>(list,HttpStatus.UNAUTHORIZED);

        }

        return response;
    }




}
