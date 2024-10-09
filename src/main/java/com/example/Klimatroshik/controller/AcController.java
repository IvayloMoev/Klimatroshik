package com.example.Klimatroshik.controller;

import com.example.Klimatroshik.model.entitiy.AC;
import com.example.Klimatroshik.service.AcService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AcController {
    private final AcService acService;
    public AcController(AcService acService) {
        this.acService = acService;
    }

    public ResponseEntity<List<AC>> getAllAc(){
        List<AC> acList = acService.getAllAC(); // Fetch the list of ACs from the service
        if (acList == null || acList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No content to return
        }
        return new ResponseEntity<>(acList, HttpStatus.OK);
    }


}
