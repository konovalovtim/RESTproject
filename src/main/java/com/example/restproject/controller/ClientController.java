package com.example.restproject.controller;

import com.example.restproject.model.Client;
import com.example.restproject.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* В данном классе будет реализована логика обработки клиентских запросов */
@RestController
@Tag(name = "Clients")
public class ClientController {
    private final ClientService clientService;

    /* @Autowired — говорит спрингу, что в этом месте необходимо внедрить зависимость.
    Реализацию ClientService мы пометили аннотацией @Service ранее,
    и теперь спринг сможет передать экземпляр этой реализации в конструктор контроллера. */
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /* @PostMapping(value = "/clients") - обработка POST запроса на адрес /clients
    ResponseEntity — класс для возврата ответов(HTTP статус код).
    Значение @RequestBody Client client подставляется из тела запроса. Об этом говорит аннотация  @RequestBody.
    Внутри тела метода мы вызываем метод create у ранее созданного сервиса и
    передаем ему принятого в параметрах контроллера клиента.
    После чего возвращаем статус 201 CREATED. */
    @Operation(summary = "Сохранение пользователя", tags = { "Clients" })
    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /* @GetMapping(value = "/clients") - обрабатываем GET запросы.
    ResponseEntity<List<Client>> - класс для возврата ответов(HTTP статус) и тело ответа, которым будет список клиентов.
    Далее, в случае если список не null и не пуст, мы возвращаем c помощью класса ResponseEntity
    сам список клиентов и HTTP статус 200 OK. Иначе мы возвращаем просто HTTP статус 404 Not Found. */
    @Operation(summary = "Вывести всех клиентов", tags = { "Clients" })
    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read() {
        final List<Client> clients = clientService.readAll();
        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /* Переменная value = "/clients/{id}", которая определена в URI,
    в параметрах метода принимаем её в качестве int переменной, с помощью аннотации @PathVariable(name = "id").
    Данный метод будет принимать запросы на uri вида /clients/{id}, где вместо {id} может быть любое численное значение.
    Данное значение, впоследствии, передается переменной int id — параметру метода. */
    @Operation(summary = "Вывести клиента по id", tags = { "Clients" })
    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") int id) {
        final Client client = clientService.read(id);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /* метод update обрабатывает PUT запросы (аннотация @PutMapping) */
    @Operation(summary = "Изменить данные клиентов", tags = { "Clients" })
    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Client client) {
        final boolean updated = clientService.update(client, id);
        return updated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /* метод delete обрабатывает DELETE запросы (аннотация DeleteMapping) */
    @Operation(summary = "Удалить клиента по id", tags = { "Clients" })
    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = clientService.delete(id);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
