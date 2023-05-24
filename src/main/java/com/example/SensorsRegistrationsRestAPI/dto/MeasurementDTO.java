package com.example.SensorsRegistrationsRestAPI.dto;

import com.example.SensorsRegistrationsRestAPI.models.Sensor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;


public class MeasurementDTO {

    @NotNull(message = "Value should not be empty!")
    @DecimalMin(value = "-100.0")
    @DecimalMax(value = "100.0")
    private double value;

    @NotNull(message = "Raining should not be empty!")
    private boolean raining;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @NotNull(message = "Sensor should not be empty!")
    private Sensor sensor;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
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
