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
    private Double value;

    @NotNull(message = "Raining should not be empty!")
    private Boolean raining;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @NotNull(message = "Sensor should not be empty!")
    private Sensor sensor;

    public MeasurementDTO(Double value, Boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public MeasurementDTO() {
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "\n" +
                "sensor=" + sensor +
                ", value=" + value +
                ", raining=" + raining +
                '}' + "\n";
    }
}
