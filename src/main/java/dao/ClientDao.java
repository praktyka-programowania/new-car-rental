package dao;


import model.Client;

import java.util.List;

public interface ClientDao
{
    Client get(int id);
    Client getByUsername(String username);
    Client getByEmail(String email);
    List<Client> getAll();

    void add(Client client);
}
