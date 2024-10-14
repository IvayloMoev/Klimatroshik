package com.example.Klimatroshik.controller;

import com.example.Klimatroshik.model.dto.AcDto;
import com.example.Klimatroshik.model.entitiy.AC;
import com.example.Klimatroshik.repository.AcRepository;
import com.example.Klimatroshik.service.AcService;
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
    public ResponseEntity<Map<String, Boolean>> createAC(@RequestBody AcDto ac){
        boolean result = acService.addAC(ac);
        Map<String,Boolean> body = new HashMap<>();
        body.put("Created", result);
        if(result){
            return new ResponseEntity<>(body, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }


}
