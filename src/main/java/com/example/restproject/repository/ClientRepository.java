package com.example.restproject.repository;


import com.example.restproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/* Интерфейс для взаимодействия с БД.
Предоставляет возможность сохранять в удобном виде Java-объекты в базе данных. */
public interface ClientRepository extends JpaRepository<Client, Integer> {}
