package com.example.Klimatroshik.service;

import com.example.Klimatroshik.model.dto.AcDto;
import com.example.Klimatroshik.model.entitiy.AC;
import com.example.Klimatroshik.repository.AcRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class AcService {
    private final AcRepository acRepository;

    public AcService(AcRepository acRepository) {
        this.acRepository = acRepository;
    }
    private final ModelMapper mapper = new ModelMapper();
    public List<AC> getAllAC(){
        return acRepository.findAll();
    }

    public AcDto getACById(String id) {
        try {

            AC ac = acRepository.findById(id).orElse(null);
            AcDto acDto = new AcDto();
            mapper.map(ac,acDto);

            if (ObjectUtils.isEmpty(acDto)) {
                throw new RuntimeException("AC not found!");
            } else {
                return acDto;
            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean addAC(AcDto acDto){
        try {
            AC ac = new AC();
            mapper.map(acDto,ac);
            acRepository.save(ac);
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
    //TODO FIX
    public boolean updateAc(AcDto acDto, String id){
        try{
            AC ac = acRepository.findById(id).orElse(null);
            mapper.map(acDto, ac);
            acRepository.save(ac);
            return true;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
