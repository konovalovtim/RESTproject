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
    public void createClient(@RequestBody ClientDTO clientDTO) {
        clientService.post(ClientMapper.INSTANCE.map(clientDTO));
    }

    @Operation(summary = "Вывести всех клиентов", tags = {"Clients"})
    @GetMapping(value = "/clients")
    public List<ClientDTO> showAllClients() {
        final List<Client> clients = clientService.get();
        return ClientMapper.INSTANCE.mapListDto(clients);
    }

    @Operation(summary = "Вывести клиента по id", tags = {"Clients"})
    @GetMapping(value = "/clients/{id}")
    public ClientDTO getClientById(@PathVariable(name = "id") Integer id) {
        final Client client = clientService.getById(id);
        return ClientMapper.INSTANCE.mapDto(client);
    }

    @Operation(summary = "Вывести клиента по name", tags = {"Clients"})
    @GetMapping(value = "/clients/name/{name}")
    public ClientDTO getClientByName(@PathVariable(name = "name") String name) {
        final Client client = clientService.findByName(name);
        return ClientMapper.INSTANCE.mapDto(client);
    }

    @Operation(summary = "Изменить данные клиентов", tags = {"Clients"})
    @PutMapping(value = "/clients/{id}")
    public void сhangeClientData(@PathVariable(name = "id") Integer id, @RequestBody ClientDTO clientDto) {
        clientService.put(ClientMapper.INSTANCE.map(clientDto), id);
    }

    @Operation(summary = "Удалить клиента по id", tags = {"Clients"})
    @DeleteMapping(value = "/clients/{id}")
    public void deleteClientById(@PathVariable(name = "id") Integer id) {
        clientService.delete(id);
    }
}