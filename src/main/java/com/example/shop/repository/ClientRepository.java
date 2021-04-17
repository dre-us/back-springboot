package com.example.shop.repository;

import com.example.shop.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ClientRepository {

    private final ArrayList<Client> clients;

    public ClientRepository() {
        clients = new ArrayList<>(Arrays.asList(
                new Client(12345, "carrera 11# 14-08"),
                new Client(11223, "cr 3 # 15-34")
        ));
    }

    public List<Client> getAll() {
        return List.copyOf(clients);
    }
}
