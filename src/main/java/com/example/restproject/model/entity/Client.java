package com.example.restproject.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

/* @Entity — указывает, что данный класс является сущностью */
@Entity
@Table(name = "clients")
@Data
public class Client {

    /* @Id - первичный ключ */
    @Id
    @Column(name = "id")
    private Integer id;

    /* @Column — указывает на имя колонки. */
    @Column(name = "name")
    @Schema(example = "Tom")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Schema(example = "tom@mail.com")
    private String email;

    @Schema(example = "1")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
