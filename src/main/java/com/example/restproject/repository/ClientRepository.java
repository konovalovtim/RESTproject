package com.example.restproject.repository;

import com.example.restproject.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
//    реализовать метод findByName в контроллере по аналогии с getById
    Client findByName(String name);
}
