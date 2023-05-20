package com.example.SensorsRegistrationsRestAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sensor_name")
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!")
    private String sensor_name;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "update_at")
    private LocalDateTime update_at;

    @Column(name = "created_who")
    @NotEmpty(message = "Name should not be empty!")
    private String created_who;

    public Sensor() {
    }

    public Sensor(String sensor_name, String created_who) {
        this.sensor_name = sensor_name;
        this.created_who = created_who;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }

    public String getCreated_who() {
        return created_who;
    }

    public void setCreated_who(String created_who) {
        this.created_who = created_who;
    }
}
