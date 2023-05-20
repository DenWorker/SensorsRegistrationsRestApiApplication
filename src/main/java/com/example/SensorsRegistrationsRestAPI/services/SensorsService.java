package com.example.SensorsRegistrationsRestAPI.services;

import com.example.SensorsRegistrationsRestAPI.models.Sensor;
import com.example.SensorsRegistrationsRestAPI.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SensorsService {
    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public List<Sensor> findAll(){
        return sensorsRepository.findAll();
    }

    public Sensor findOne(int id){
        return sensorsRepository.findById(id).orElse(null);
    }
}
