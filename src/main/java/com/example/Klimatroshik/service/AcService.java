package com.example.Klimatroshik.service;

import com.example.Klimatroshik.model.entitiy.AC;
import com.example.Klimatroshik.response.AcRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcService {
    private final AcRepository acRepository;

    public AcService(AcRepository acRepository) {
        this.acRepository = acRepository;
    }

    public List<AC> getAllAC(){
        return acRepository.findAll();
    }

    public AC getACById(String id) {
        try {
            Optional<AC> ac = acRepository.findById(id);
            if (ac.isPresent()) {
                return ac.get();
            } else {
                throw new Exception("AC not found!");
            }
        }catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
