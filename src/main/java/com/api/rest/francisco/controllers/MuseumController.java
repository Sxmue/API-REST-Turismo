package com.api.rest.francisco.controllers;


import com.api.rest.francisco.models.MuseumDTO;
import com.api.rest.francisco.services.museum.MuseumManagmentImpl;
import com.api.rest.francisco.services.security.SecurityServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Obtener Todos los museos", description = "Devuelve todos los museos disponibles en la API, necesario el token de seguridad,para obtenerlo pasar por user/login.")
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
    @Operation(summary = "Obtener Todos los museos de un municipio concreto", description = "Devuelve todos los museos disponibles en la API de un municipio concreto, necesario el token de seguridad,para obtenerlo pasar por user/login.")
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
    @Operation(summary = "Obtener museo por nombre", description = "Devuelve todos los datos de un museo concreto a traves de su nombre, necesario el token de seguridad,para obtenerlo pasar por user/login.")
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
    @Operation(summary = "Obtener Todos los museos de una provincia concreta", description = "Devuelve todos los museos disponibles en la API de una provincia concreta, necesario el token de seguridad,para obtenerlo pasar por user/login.")
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
    @Operation(summary = "Obtener Todos los museos de un codigo postal en concreto", description = "Devuelve todos los museos disponibles en la API de un codigo postal en concreto, necesario el token de seguridad,para obtenerlo pasar por user/login.")
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
    @Operation(summary = "Obtener Todos los museos de un tipo concreto", description = "Devuelve todos los museos disponibles en la API de un tipo concreto, por ejemplo solo yacimientos arqueológicos, necesario el token de seguridad,para obtenerlo pasar por user/login.")
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
    @Operation(summary = "Obtener todos los museos cercanos a la posicion del usuario", description = "Devuelve todos los museos que esten cercanos a la posicion del usuario, pasada a traves de parametro latitud y longitud, necesario el token de seguridad,para obtenerlo pasar por user/login.")
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


    @PostMapping("/create/{token}")
    @Operation(summary = "Inserta un nuevo museo en la base de datos", description = "Inserta un nuevo museo en la base de datos, necesario el token de seguridad,para obtenerlo pasar por user/login.")
    public ResponseEntity<MuseumDTO> newMuseum(@RequestBody MuseumDTO museumDTO,@PathVariable Integer  token){

        ResponseEntity<MuseumDTO> response = null;

        MuseumDTO m = null;

        //Si el token es correcto
        if (Boolean.TRUE.equals(securityService.validateToken(token))){

            //Si minimo el museo tiene el nombre que es lo que usamos en registrer para comprobar
            if(museumDTO.name() != null) {

                m = museumManagment.registerMuseum(museumDTO);

                response = new ResponseEntity<>(m, HttpStatus.OK);

                //Si el nombre es nulo devuelve bad request
            }else  response = new ResponseEntity<>(m,HttpStatus.BAD_REQUEST);

        }else{

            response = new ResponseEntity<>(m,HttpStatus.UNAUTHORIZED);

        }

        return response;
    }


    @PutMapping ("/update/{token}")
    @Operation(summary = "Actualiza un museo en la base de datos", description = "Actualiza un museo en la base de datos, necesario el token de seguridad,para obtenerlo pasar por user/login.")
    public ResponseEntity<MuseumDTO> updateMuseum(@RequestBody MuseumDTO museumDTO,@PathVariable Integer  token){

        ResponseEntity<MuseumDTO> response = null;

        MuseumDTO m = museumManagment.getMuseumByName(museumDTO.name());

        //Si el token es correcto
        if (Boolean.TRUE.equals(securityService.validateToken(token))){

            //Si minimo el museo tiene el nombre que es lo que usamos en registrer para comprobar
            if(m != null) {

                m = museumManagment.updateMuseum(museumDTO);

                response = new ResponseEntity<>(m, HttpStatus.OK);

                //Si el nombre es nulo devuelve bad request
            }else  response = new ResponseEntity<>(m,HttpStatus.BAD_REQUEST);

        }else{

            response = new ResponseEntity<>(m,HttpStatus.UNAUTHORIZED);

        }

        return response;
    }


    @DeleteMapping ("/delete/{name}/{token}")
    @Operation(summary = "Borra un museo de la base de datos", description = "Elimina un museo de la base de datos, necesario el token de seguridad,para obtenerlo pasar por user/login.")
    public ResponseEntity<MuseumDTO> deleteMuseum(@PathVariable String name, @PathVariable Integer  token){

        ResponseEntity<MuseumDTO> response = null;

        MuseumDTO m = museumManagment.getMuseumByName(name);

        //Si el token es correcto
        if (Boolean.TRUE.equals(securityService.validateToken(token))){

            //Si minimo el museo tiene el nombre que es lo que usamos en registrer para comprobar
            if(m != null) {

                m = museumManagment.deleteMuseum(m);

                response = new ResponseEntity<>(m, HttpStatus.OK);

                //Si el nombre es nulo devuelve bad request
            }else  response = new ResponseEntity<>(m,HttpStatus.BAD_REQUEST);

        }else{
            m=null;

            response = new ResponseEntity<>(m,HttpStatus.UNAUTHORIZED);

        }

        return response;
    }



}
