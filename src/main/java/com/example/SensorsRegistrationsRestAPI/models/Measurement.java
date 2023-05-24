package com.example.SensorsRegistrationsRestAPI.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    @NotNull(message = "Value should not be empty!")
    @DecimalMin(value = "-100.0")
    @DecimalMax(value = "100.0")
    private double value;

    @Column(name = "raining")
    @NotNull(message = "Raining should not be empty!")
    private boolean raining;

    @Column(name = "measurement_time")
    private LocalDateTime measurementTime;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne()
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    @NotNull(message = "Sensor should not be empty!")
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
