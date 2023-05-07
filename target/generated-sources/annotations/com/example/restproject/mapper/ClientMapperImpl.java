package com.example.restproject.mapper;

import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-06T19:52:28+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client map(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDTO.getId() );
        client.setName( clientDTO.getName() );
        client.setEmail( clientDTO.getEmail() );

        return client;
    }

    @Override
    public ClientDTO mapDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( client.getId() );
        clientDTO.setName( client.getName() );
        clientDTO.setEmail( client.getEmail() );

        return clientDTO;
    }

    @Override
    public List<ClientDTO> mapListDto(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( clients.size() );
        for ( Client client : clients ) {
            list.add( mapDto( client ) );
        }

        return list;
    }
}
