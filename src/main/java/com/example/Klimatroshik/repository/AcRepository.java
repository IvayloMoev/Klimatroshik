package com.example.Klimatroshik.repository;

import com.example.Klimatroshik.model.entitiy.AC;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AcRepository extends MongoRepository<AC, String>{

}
