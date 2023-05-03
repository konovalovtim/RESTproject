package com.example.restproject.model.mapper;

import com.example.restproject.model.ClientModel;
import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientModel toModel(ClientDTO dto);

    Client toEntity(ClientModel model);

    ClientModel toModel(Client entity);

    ClientDTO toDto(ClientModel model);
}
