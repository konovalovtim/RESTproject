package com.example.restproject.model;

import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    ClientDTO toClientDTO(Client client);
    Client toClient(ClientDTO clientDTO);
}
