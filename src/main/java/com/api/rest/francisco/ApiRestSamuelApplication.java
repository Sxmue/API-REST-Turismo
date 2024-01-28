package com.api.rest.francisco;

import com.api.rest.francisco.models.Museum;
import com.api.rest.francisco.services.MuseumManagmentImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ApiRestSamuelApplication implements CommandLineRunner {

	@Autowired
	MuseumManagmentImpl museumManagment;

	public static void main(String[] args) {
		SpringApplication.run(ApiRestSamuelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Museum>> typeReference = new TypeReference<List<Museum>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/dataset-orbe_museos.json");

		try {
			List<Museum> museums= mapper.readValue(inputStream,typeReference);
			museumManagment.registerANewListMuseum(museums);
		}catch (IOException e){
			System.out.println(e.getMessage());
		}



	}
}
