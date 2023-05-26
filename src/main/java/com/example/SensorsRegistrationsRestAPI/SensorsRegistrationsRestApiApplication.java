package com.example.SensorsRegistrationsRestAPI;

import com.example.SensorsRegistrationsRestAPI.dto.MeasurementDTO;
import com.example.SensorsRegistrationsRestAPI.models.Measurement;
import com.example.SensorsRegistrationsRestAPI.models.Sensor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class SensorsRegistrationsRestApiApplication {

    private static final RestTemplate response = new RestTemplate();


    public static void main(String[] args) {
        SpringApplication.run(SensorsRegistrationsRestApiApplication.class, args);
        System.out.println("Hello world!");

        //sensorsPost();
        //List<Sensor> sensorList = getSensorsFromServer();

        //measurementPost(getSensorsFromServer());
        List<MeasurementDTO> measurementDTOList = getMeasurementsFromServer();
        System.out.println(measurementDTOList);
    }

    private static void sensorsPost() {
        List<Sensor> sensorList = new ArrayList<>();
        sensorList.add(new Sensor("DHT11"));
        sensorList.add(new Sensor("DHT22"));
        sensorList.add(new Sensor("DS18B20"));
        sensorList.add(new Sensor("BME280"));
        sensorList.add(new Sensor("AM2302"));
        sensorList.add(new Sensor("HTU21D"));
        sensorList.add(new Sensor("SHT31"));
        sensorList.add(new Sensor("BMP180"));
        sensorList.add(new Sensor("DHT12"));
        sensorList.add(new Sensor("DS18S20"));
        sensorList.add(new Sensor("BME680"));
        sensorList.add(new Sensor("AM2315"));
        sensorList.add(new Sensor("HTU20D"));
        sensorList.add(new Sensor("SHT35"));
        sensorList.add(new Sensor("BMP280"));
        sensorList.add(new Sensor("DHT11S"));
        sensorList.add(new Sensor("DS18S22"));
        sensorList.add(new Sensor("DHT23"));
        sensorList.add(new Sensor("BME770"));
        sensorList.add(new Sensor("DHT33"));

        for (Sensor sensor : sensorList) {
            response.postForObject(
                    "http://localhost:8080/sensors/registration",
                    new HttpEntity<>(sensor),
                    String.class);
        }
    }

    private static List<Sensor> getSensorsFromServer() {
        ResponseEntity<List<Sensor>> responseEntity = response.exchange(
                "http://localhost:8080/sensors/notDTO",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Sensor>>() {
                });
        return responseEntity.getBody();
    }

    private static void measurementPost(List<Sensor> sensorList) {
        for (int i = 0; i < 1000; i++) {
            MeasurementDTO measurementDTO = new MeasurementDTO(
                    ThreadLocalRandom.current().nextDouble(-100.00, 100.00),
                    ThreadLocalRandom.current().nextBoolean(),
                    sensorList.get(ThreadLocalRandom.current().nextInt(0, sensorList.size() - 1)));
            response.postForObject(
                    "http://localhost:8080/measurements/add",
                    new HttpEntity<>(measurementDTO),
                    String.class);
        }
    }

    private static List<MeasurementDTO> getMeasurementsFromServer() {
        ResponseEntity<List<MeasurementDTO>> responseEntity = response.exchange(
                "http://localhost:8080/measurements",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MeasurementDTO>>() {
                });
        return responseEntity.getBody();
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
