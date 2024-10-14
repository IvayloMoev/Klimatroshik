package com.example.Klimatroshik.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PowerDto {
    @JsonProperty("Hot_Out")
    private int hotOut;

    @JsonProperty("Cold_Out")
    private int coldOut;

}
