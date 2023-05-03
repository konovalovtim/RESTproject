package com.example.restproject.model.mapper;

import com.example.restproject.model.ClientModel;
import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientModel toModel(ClientDTO dto);

    Client toEntity(ClientModel model);

    ClientModel toModel(Client entity);

    ClientDTO toDto(ClientModel model);
}
