package com.example.SensorsRegistrationsRestAPI;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SensorsRegistrationsRestApiApplication {

	//POST:http://localhost:8080/sensors/registration
	// http://localhost:8080/sensors
	// http://localhost:8080/sensors/5
	// http://localhost:8080/sensors/100
	public static void main(String[] args) {
		SpringApplication.run(SensorsRegistrationsRestApiApplication.class, args);

		System.out.println("Hello world!");
	}


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
