package com.example.restproject.controller;

import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import com.example.restproject.mapper.ClientMapper;
import com.example.restproject.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Clients")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(summary = "Сохранение пользователя", tags = {"Clients"})
    @PostMapping(value = "/clients")
    public ResponseEntity<?> createClient(@RequestBody ClientDTO clientDTO) {
        clientService.post(ClientMapper.INSTANCE.map(clientDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Вывести всех клиентов", tags = {"Clients"})
    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> showAllClients() {
        final List<Client> clients = clientService.get();
        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(ClientMapper.INSTANCE.mapListDto(clients), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Вывести клиента по id", tags = {"Clients"})
    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable(name = "id") int id) {
        final Client client = clientService.getById(id);
        return client != null
                ? new ResponseEntity<>(ClientMapper.INSTANCE.mapDto(client), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Вывести клиента по name", tags = {"Clients"})
    @GetMapping("/clients/{name}")
    public ResponseEntity<ClientDTO> getClientByName(@PathVariable(name = "name") String name) {
        final Client client = clientService.findByName(name);
        return client != null
                ? new ResponseEntity<>(ClientMapper.INSTANCE.mapDto(client), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Изменить данные клиентов", tags = {"Clients"})
    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> ChangeClientData(@PathVariable(name = "id") int id, @RequestBody Client client) {
        final boolean puted = clientService.put(client, id);
        return puted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Operation(summary = "Удалить клиента по id", tags = {"Clients"})
    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable(name = "id") int id) {
        final boolean deleted = clientService.delete(id);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}