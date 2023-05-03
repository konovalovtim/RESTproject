package com.example.restproject.service;

import com.example.restproject.model.entity.Client;
import com.example.restproject.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
/* Реализация JPA интерфейса JpaRepository */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void post(Client client) {
        clientRepository.save(client);
    }

    public List<Client> get() {
        return clientRepository.findAll();
    }

    public Client getById(int id) {
        return clientRepository.getById(id);
    }

    public Client findByName(String name) {
        return clientRepository.findByName(name);
    }

    public boolean put(Client client, int id) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}