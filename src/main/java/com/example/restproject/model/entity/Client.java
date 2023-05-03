package com.example.restproject.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @Schema(example = "Tom")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Schema(example = "tom@mail.com")
    private String email;

}
