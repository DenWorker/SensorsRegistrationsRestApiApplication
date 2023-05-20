package com.example.SensorsRegistrationsRestAPI.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SensorDTO {

    @Column(name = "sensor_name")
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!")
    private String sensor_name;

    @Column(name = "created_who")
    @NotEmpty(message = "Name should not be empty!")
    private String created_who;

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public String getCreated_who() {
        return created_who;
    }

    public void setCreated_who(String created_who) {
        this.created_who = created_who;
    }
}
