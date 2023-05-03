package com.example.restproject.mapper;

import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    Client map(ClientDTO clientDTO);
    ClientDTO mapDto(Client client);
    List<ClientDTO> mapListDto(List<Client> clients);

}
