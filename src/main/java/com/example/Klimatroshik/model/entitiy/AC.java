package com.example.Klimatroshik.model.entitiy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Document("AC")
public class AC {
    @Id
    private String id;

//    private Long customId;
    private String model;
    private String manufacturer;
    private String classGrade;
    private String refAgent;
    private int hotPowerOut;
    private int coldPowerOut;

}
