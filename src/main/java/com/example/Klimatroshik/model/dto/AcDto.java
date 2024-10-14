package com.example.Klimatroshik.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcDto {
    @JsonProperty("Model")
    private String model;

    @JsonProperty("Manufacturer")
    private String manufacturer;

    @JsonProperty("Class_Grade")
    private String classGrade;

    @JsonProperty("Ref_Agent")
    private String refAgent;

    @JsonProperty("Power")
    private PowerDto power;

    @JsonProperty("Log")
    private LogDto log;

}
