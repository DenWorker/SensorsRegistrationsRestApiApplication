package com.example.SensorsRegistrationsRestAPI.services;

import com.example.SensorsRegistrationsRestAPI.models.Measurement;
import com.example.SensorsRegistrationsRestAPI.repositories.MeasurementsRepository;
import com.example.SensorsRegistrationsRestAPI.utilMeasurements.MeasurementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository) {
        this.measurementsRepository = measurementsRepository;
    }

    public List<Measurement> findAll() {
        return measurementsRepository.findAll();
    }

    public Measurement findById(int id) {
        return measurementsRepository.findById(id).orElseThrow(MeasurementNotFoundException::new);
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementsRepository.save(measurement);
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setMeasurementTime(LocalDateTime.now());
    }
}
