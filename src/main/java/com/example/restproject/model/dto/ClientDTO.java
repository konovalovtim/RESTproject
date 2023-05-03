package com.example.restproject.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
    private Integer id;
    private String name;
    private String email;
}
