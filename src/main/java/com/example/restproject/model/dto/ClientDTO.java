package com.example.restproject.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ClientDTO {

    /* @Id - первичный ключ */
    @Id
    @Column(name = "id")
    private Integer idDTO;

    /* @Column — указывает на имя колонки. */
    @Column(name = "name")
    private String nameDTO;

    @Column(name = "email")
    private String emailDTO;

    @Schema(example = "1")
    public Integer getIdDTO() {
        return idDTO;
    }

    public void setIdDTO(Integer id) {
        this.idDTO = id;
    }

    @Schema(example = "Tom")
    public String getNameDTO() {
        return nameDTO;
    }

    public void setNameDTO(String name) {
        this.nameDTO = name;
    }

    @Schema(example = "tom@mail.com")
    public String getEmailDTO() {
        return emailDTO;
    }

    public void setEmailDTO(String email) {
        this.emailDTO = email;
    }
}
