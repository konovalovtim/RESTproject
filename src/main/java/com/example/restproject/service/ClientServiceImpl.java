package com.example.restproject.service;

import com.example.restproject.model.Client;
import com.example.restproject.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client read(int id) {
        return clientRepository.getOne(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Хранилище клиентов
//    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();
//
//    // Переменная для генерации ID клиента
//    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();
//    @Override
//    public void create(Client client) {
//        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
//        client.setId(clientId);
//        CLIENT_REPOSITORY_MAP.put(clientId, client);
//    }
//    @Override
//    public List<Client> readAll() { return new ArrayList<>(CLIENT_REPOSITORY_MAP.values()); }
//    @Override
//    public Client read(int id) { return CLIENT_REPOSITORY_MAP.get(id); }
//    @Override
//    public boolean update(Client client, int id) {
//        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
//            client.setId(id);
//            CLIENT_REPOSITORY_MAP.put(id, client);
//            return true;
//        }
//        return false;
//    }
//    @Override
//    public boolean delete(int id) { return CLIENT_REPOSITORY_MAP.remove(id) != null; }
}
