package com.example.restproject.model.dto;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
public class ClientDTO {
    private Integer id;
    private String name;
    private String email;
}
