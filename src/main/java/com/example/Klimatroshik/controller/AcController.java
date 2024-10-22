package com.example.Klimatroshik.controller;

import com.example.Klimatroshik.model.dto.AcDto;
import com.example.Klimatroshik.model.entitiy.AC;
import com.example.Klimatroshik.repository.AcRepository;
import com.example.Klimatroshik.service.AcService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/klimatroshik")
public class AcController {

    private final AcService acService;
    public AcController(AcService acService) {
        this.acService = acService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AC>> getAllAc(){
        List<AC> acList = acService.getAllAC(); // Fetch the list of ACs from the service
        if (acList == null || acList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No content to return
        }
        return new ResponseEntity<>(acList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Boolean>> createAC(@RequestBody AcDto acDto){
        boolean result = acService.addAC(acDto);
        Map<String,Boolean> body = new HashMap<>();
        body.put("Created", result);
        if(result){
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    // Add id dto
    //TODO Serialize name spaces
    @GetMapping("/findId")
    public ResponseEntity<Map<String, AcDto>> findById(@RequestParam String id){
        AcDto acDto = acService.getACById(id);
        Map<String, AcDto> body = new HashMap<>();
        body.put("AC: ", acDto);
        if(acDto != null){
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Boolean>> deleteAc(@RequestParam String id){
        boolean isDeleted = acService.deleteAc(id);
        Map<String, Boolean> body = new HashMap<>();
        body.put("AC: ", isDeleted);
        if(isDeleted){
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
    //TODO FIX
    @PutMapping("/update")
    public ResponseEntity<Map<String, Boolean>> updateAc(@RequestParam String id, @RequestBody AcDto acDto){
        boolean isUpdated = acService.updateAc(acDto,id);
        Map<String, Boolean> body = new HashMap<>();
        body.put("Updated", isUpdated);
        if(isUpdated){
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }


}

