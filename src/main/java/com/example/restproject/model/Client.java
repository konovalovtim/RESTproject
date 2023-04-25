package com.example.restproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @Schema(example = "1")
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
    @Schema(example = "Tom")
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
    @Schema(example = "tom@mail.com")
    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
