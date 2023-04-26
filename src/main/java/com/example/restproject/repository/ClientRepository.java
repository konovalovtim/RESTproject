package com.example.restproject.repository;


import com.example.restproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

// интерфейс для взаимодействия с БД
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
