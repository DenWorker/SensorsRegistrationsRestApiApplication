package com.example.SensorsRegistrationsRestAPI;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SensorsRegistrationsRestApiApplication {

    // POST: http://localhost:8080/sensors/registration
    /*
	{
		"name": "GG45"
	}
    */
    // GET:  http://localhost:8080/sensors
    // GET:  http://localhost:8080/sensors/5
    // GET:  http://localhost:8080/sensors/100

    // POST  http://localhost:8080/measurements/add
    /*
    {
        "value": 24.7,
        "raining": false,
        "sensor": {
            "id": 8
        }
    }
    */
    // GET:  http://localhost:8080/measurements
    // GET:  http://localhost:8080/measurements/6
    // GET:  http://localhost:8080/measurements/100
    // GET:  http://localhost:8080/measurements/rainyDaysCount
    public static void main(String[] args) {
        SpringApplication.run(SensorsRegistrationsRestApiApplication.class, args);

        System.out.println("Hello world!");
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
