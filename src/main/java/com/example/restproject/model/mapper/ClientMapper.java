package com.example.restproject.model.mapper;

import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toModel(ClientDTO dto);
    ClientDTO toDto(Client model);
}
