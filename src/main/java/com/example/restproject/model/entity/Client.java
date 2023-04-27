package com.example.restproject.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

/* @Entity — указывает, что данный класс является сущностью */
@Entity
@Table(name = "clients")
public class Client {

    /* @Id - первичный ключ */
    @Id
    @Column(name = "id")
    private Integer id;

    /* @Column — указывает на имя колонки. */
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Schema(example = "1")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Schema(example = "Tom")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Schema(example = "tom@mail.com")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
