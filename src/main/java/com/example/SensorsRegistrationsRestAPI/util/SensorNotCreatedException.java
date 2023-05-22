package com.example.SensorsRegistrationsRestAPI.util;

public class SensorNotCreatedException extends RuntimeException{
    public SensorNotCreatedException(String message) {
        super(message);
    }
}
