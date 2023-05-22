package com.example.SensorsRegistrationsRestAPI.util;

import com.example.SensorsRegistrationsRestAPI.models.Sensor;
import com.example.SensorsRegistrationsRestAPI.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {
    private final SensorsService sensorsService;

    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Sensor.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Sensor sensor = (Sensor) o;
        if (sensorsService.hasSensor(sensor.getName())) {
            errors.rejectValue("name", "", "This sensor is already taken!");
        }
    }
}

