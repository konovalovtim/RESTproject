package com.example.restproject.controller;

import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import com.example.restproject.mapper.ClientMapper;
import com.example.restproject.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Сохранение пользователя", tags = {"Clients"})
    @PostMapping(value = "/clients")
    public ResponseEntity<?> createClient(@RequestBody ClientDTO clientDTO) {
        clientService.post(ClientMapper.INSTANCE.map(clientDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Вывести всех клиентов", tags = {"Clients"})
    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientDTO>> showAllClients() {
        final List<Client> clients = clientService.get();
        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(ClientMapper.INSTANCE.mapListDto(clients), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Вывести клиента по id", tags = {"Clients"})
    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable(name = "id") Integer id) {
        final Client client = clientService.getById(id);
        return client != null
                ? new ResponseEntity<>(ClientMapper.INSTANCE.mapDto(client), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Вывести клиента по name", tags = {"Clients"})
    @GetMapping(value = "/clients/name/{name}")
    public ResponseEntity<ClientDTO> getClientByName(@PathVariable(name = "name") String name) {
        final Client client = clientService.findByName(name);
        return client != null
                ? new ResponseEntity<>(ClientMapper.INSTANCE.mapDto(client), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Изменить данные клиентов", tags = {"Clients"})
    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> сhangeClientData(@PathVariable(name = "id") Integer id, @RequestBody ClientDTO clientDto) {
        final boolean puted = clientService.put(ClientMapper.INSTANCE.map(clientDto), id);
        return puted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Operation(summary = "Удалить клиента по id", tags = {"Clients"})
    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable(name = "id") Integer id) {
        final boolean deleted = clientService.delete(id);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}