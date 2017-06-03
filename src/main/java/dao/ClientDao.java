package dao;


import model.Client;

import java.util.List;

public interface ClientDao
{
    Client get(int id);
    List<Client> getAll();

    void add(Client client);
}
