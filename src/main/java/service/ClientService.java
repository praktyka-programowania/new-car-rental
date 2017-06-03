package service;

import model.Client;

import java.util.List;

public interface ClientService
{
    Client get(int id);
    List<Client> getAll();

    void add(Client client);
}
