package com.example.restproject.repository;

import com.example.restproject.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Интерфейс для взаимодействия с БД.
Предоставляет возможность сохранять в удобном виде Java-объекты в базе данных(связь Java объектов и записей в БД) */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {}
