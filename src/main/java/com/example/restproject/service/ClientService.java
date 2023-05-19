package com.example.restproject.service;

import com.example.restproject.model.entity.Client;
import com.example.restproject.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void createNewClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> showAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        return clientRepository.getReferenceById(id);
    }

    public Client getClientByName(String name) {
        return clientRepository.findByName(name);
    }

    public boolean сhangeClientData(Client client, int id) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    public boolean deleteClientById(int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}