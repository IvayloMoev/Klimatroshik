package com.example.Klimatroshik.service;

import com.example.Klimatroshik.model.dto.AcDto;
import com.example.Klimatroshik.model.entitiy.AC;
import com.example.Klimatroshik.repository.AcRepository;
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
                throw new RuntimeException("AC not found!");
            }
        }catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean addAC(AcDto dto){
        try {
            AC ac = new AC();
            ac.setModel(dto.getModel());
            ac.setManufacturer(dto.getManufacturer());
            ac.setRefAgent(dto.getRefAgent());
            ac.setClassGrade(dto.getClassGrade());
            ac.setHotPowerOut(dto.getPower().getHotOut());
            ac.setColdPowerOut(dto.getPower().getColdOut());
            AC savedAc = acRepository.save(ac);
            return true;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public boolean deleteAc(String id){
       try {
           acRepository.deleteById(id);
           return true;
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
    }
}
