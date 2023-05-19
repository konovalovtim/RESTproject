package com.example.restproject.model.dto;

import lombok.*;

@Getter
@Setter
public class ClientDTO {
    private Integer id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'';
    }
}
