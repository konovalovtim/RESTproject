package com.example.restproject.service;

import com.example.restproject.model.ClientMapper;
import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import com.example.restproject.repository.ClientRepository;
import com.example.restproject.repository.ClientRepositoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/* Реализация JPA интерфейса JpaRepository */
@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ClientRepositoryDTO clientRepositoryDTO;
    private ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getAll() {
//        return clientRepositoryDTO.findAll();

        List<Client> clients = clientRepository.findAll();
        return clients.stream().map((user) -> clientMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    public ClientDTO getById(int id) {
//        return clientRepositoryDTO.getOne(id);
        Client client = clientRepository.findById(id).get();
        //return UserMapper.mapToUserDto(user);
        //return modelMapper.map(user, UserDto.class);
        return ClientMapper.MAPPER.mapToUserDto(client);
    }

    public ClientDTO put(ClientDTO clientDTO) {
//        clientRepository.save(client);
        Client client = ClientMapper.MAPPER.mapToUser(clientDTO);
        Client savedClient = clientRepository.save(client);
        ClientDTO savedClientDto = ClientMapper.MAPPER.mapToUserDto(savedClient);
        return savedClientDto;
    }

    public boolean update(Client client, int id) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }
        return false;

//        Client existingClient = ClientRepository.findById(clientDTO.getId()).get();
//
//        existingClient.setId(clientDTO.getId());
//        existingClient.setName(clientDTO.getName());
//        existingClient.setEmail(clientDTO.getEmailAddress());
//        Client updatedClient = clientRepository.save(existingClient);
//        return ClientMapper.MAPPER.mapToUserDto(updatedClient);
    }

    public boolean delete(int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
