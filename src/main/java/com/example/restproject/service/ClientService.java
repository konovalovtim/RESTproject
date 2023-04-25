package com.example.restproject.service;

import com.example.restproject.model.Client;

import java.util.List;

public interface ClientService {
    /* Создает нового клиента */
    void create(Client client);

    /* Возвращает список всех имеющихся клиентов */
    List<Client> readAll();

    /* Возвращает клиента по его ID */
    Client read(int id);

    /* Обновляет клиента с заданным ID, в соответствии с переданным клиентом,
     true если данные были обновлены, иначе false */
    boolean update(Client client, int id);

    /**
     * Удаляет клиента с заданным IDtrue если клиент был удален, иначе false */
    boolean delete(int id);
}
