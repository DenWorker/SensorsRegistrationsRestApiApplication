package com.example.SensorsRegistrationsRestAPI.dto;

import com.example.SensorsRegistrationsRestAPI.models.Sensor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class MeasurumentDTO {

    @NotEmpty(message = "Value should not be empty!")
    @Size(min = -100, max = 100, message = "Value should be between -100 and 100 characters!")
    private double value;

    @NotEmpty(message = "Raining should not be empty!")
    private boolean raining;


    @NotEmpty(message = "Sensor should not be empty!")
    private Sensor sensor;

    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
