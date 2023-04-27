package com.example.restproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

/* @Entity — указывает, что данный класс является сущностью.
@JsonIgnoreProperties - для того чтобы избавиться от ленивой инициализации -
(Хибернейт использует прокси классы для ленивой загрузки данных (т.е. по необходимости, а не сразу))
@XmlAccessorType задает, что доступ будет осуществляться непосредственно к полям (не нужно делать getter-ов) */
@Entity
@Table(name = "clients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlRootElement(name = "Clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

    /* @Id - первичный ключ
    @GeneratedValue — указывает, что данное свойство будет создаваться согласно указанной стратегии -
    (запред создания одинаковых id).
    @SequenceGenerator - генератор последовательности */
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "clientsIdSeq", sequenceName = "clients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientsIdSeq")
    @JsonProperty("id")
    private Integer id;

    /* @Column — указывает на имя колонки. */
    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "email")
    @JsonProperty("email")
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
