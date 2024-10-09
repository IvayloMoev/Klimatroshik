package com.example.Klimatroshik.model.entitiy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("ac")
public class AC {
    @Id
    private String id;

    private String model;
    private String manufacturer;
    private String classGrade;
    private String refAgent;
    private String hotPowerOut;
    private String coldPowerOut;

}
