package com.example.restproject.controller;

import com.example.restproject.model.dto.ClientDTO;
import com.example.restproject.model.entity.Client;
import com.example.restproject.mapper.ClientMapper;
import com.example.restproject.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Tag(name = "Clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Сохранение пользователя", tags = {"Clients"})
    @PostMapping(value = "/clients")
    public void createClient(@RequestBody ClientDTO clientDTO) {
        clientService.createNewClient(ClientMapper.INSTANCE.map(clientDTO));
        log.info("client: " + clientDTO.toString() + " add");
    }

    @Operation(summary = "Вывести всех клиентов", tags = {"Clients"})
    @GetMapping(value = "/clients")
    public List<ClientDTO> showAllClients() {
        final List<Client> clients = clientService.displayAllClients();
        log.info("display all clients");
        return ClientMapper.INSTANCE.mapListDto(clients);
    }

    @Operation(summary = "Вывести клиента по id", tags = {"Clients"})
    @GetMapping(value = "/clients/{id}")
    public ClientDTO getClientById(@PathVariable(name = "id") Integer id) {
        final Client client = clientService.getOneClientById(id);
        log.info("return from db client: " + client.toString());
        return ClientMapper.INSTANCE.mapDto(client);
    }

    @Operation(summary = "Вывести клиента по name", tags = {"Clients"})
    @GetMapping(value = "/clients/name/{name}")
    public ClientDTO getClientByName(@PathVariable(name = "name") String name) {
        final Client client = clientService.getOneClientByName(name);
        log.info("return from db client: " + client.toString());
        return ClientMapper.INSTANCE.mapDto(client);
    }

    @Operation(summary = "Изменить данные клиентов", tags = {"Clients"})
    @PutMapping(value = "/clients/{id}")
    public void сhangeClientData(@PathVariable(name = "id") Integer id, @RequestBody ClientDTO clientDto) {
        clientService.сhangeClientDataById(ClientMapper.INSTANCE.map(clientDto), id);
        log.info("client data by id: " + id + " changed to: " + clientDto.toString());
    }

    @Operation(summary = "Удалить клиента по id", tags = {"Clients"})
    @DeleteMapping(value = "/clients/{id}")
    public void deleteClientById(@PathVariable(name = "id") Integer id) {
        clientService.deleteOneClientById(id);
        log.info("remove client by id: " + id);
    }
}