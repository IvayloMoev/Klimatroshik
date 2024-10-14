package com.example.Klimatroshik.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogDto {
    @JsonProperty("Email")
    private String email;

    @JsonProperty("IP_Address")
    private String ip;
}
