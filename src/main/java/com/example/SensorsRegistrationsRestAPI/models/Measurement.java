package com.example.SensorsRegistrationsRestAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    @NotEmpty(message = "Value should not be empty!")
    @Size(min = -100, max = 100, message = "Value should be between -100 and 100 characters!")
    private double value;

    @Column(name = "raining")
    @NotEmpty(message = "Raining should not be empty!")
    private boolean raining;

    @Column(name = "measurement_time")
    private LocalDateTime measurementTime;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    @NotEmpty(message = "Sensor should not be empty!")
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(int id, double value, boolean raining, Sensor sensor) {
        this.id = id;
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public LocalDateTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(LocalDateTime measurementTime) {
        this.measurementTime = measurementTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
