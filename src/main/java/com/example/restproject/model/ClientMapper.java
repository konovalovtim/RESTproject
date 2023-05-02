package com.example.restproject.model;

import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper/*(uses = {PeopleMapper.class})*/
public interface ClientMapper {
    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);
//    @Mapping(source = "email", target = "emailAddress")
    ClientDTO mapToUserDto(Client client);
//    @Mapping(source = "emailAddress", target = "email")
    Client mapToUser(ClientDTO clientDTO);
}
