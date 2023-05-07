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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Slf4j
@RestController
@Tag(name = "Clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    private static Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Operation(summary = "Сохранение пользователя", tags = {"Clients"})
    @PostMapping(value = "/clients")
    public void createClient(@RequestBody ClientDTO clientDTO) {
        clientService.createNewClient(ClientMapper.INSTANCE.map(clientDTO));
        logger.info("client: " + clientDTO.toString() + " add");
    }

    @Operation(summary = "Вывести всех клиентов", tags = {"Clients"})
    @GetMapping(value = "/clients")
    public List<ClientDTO> showAllClients() {
        final List<Client> clients = clientService.displayAllClients();
        logger.info("all clients: " + clients.toString());
        return ClientMapper.INSTANCE.mapListDto(clients);
    }

    @Operation(summary = "Вывести клиента по id", tags = {"Clients"})
    @GetMapping(value = "/clients/{id}")
    public ClientDTO getClientById(@PathVariable(name = "id") Integer id) {
        final Client client = clientService.getOneClientById(id);
        logger.info("client with id: " + id + " is: " + client.toString());
        return ClientMapper.INSTANCE.mapDto(client);
    }

    @Operation(summary = "Вывести клиента по name", tags = {"Clients"})
    @GetMapping(value = "/clients/name/{name}")
    public ClientDTO getClientByName(@PathVariable(name = "name") String name) {
        final Client client = clientService.getOneClientByName(name);
        logger.info("client with name: " + name + " is: " + client.toString());
        return ClientMapper.INSTANCE.mapDto(client);
    }

    @Operation(summary = "Изменить данные клиентов", tags = {"Clients"})
    @PutMapping(value = "/clients/{id}")
    public void сhangeClientData(@PathVariable(name = "id") Integer id, @RequestBody ClientDTO clientDto) {
        clientService.сhangeClientDataById(ClientMapper.INSTANCE.map(clientDto), id);
        logger.info("client data by id: " + id + " changed to: " + clientDto.toString());
    }

    @Operation(summary = "Удалить клиента по id", tags = {"Clients"})
    @DeleteMapping(value = "/clients/{id}")
    public void deleteClientById(@PathVariable(name = "id") Integer id) {
        clientService.deleteOneClientById(id);
        logger.info("remove client by id: " + id);
    }
}