package service.impl;


import dao.ClientDao;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ClientService;

import java.util.Collections;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService
{
    @Autowired
    private ClientDao clientDao;

    public Client get(int id)
    {
        return clientDao.get(id);
    }

    @Override
    public Client getByUsername(String username)
    {
        return clientDao.getByUsername(username);
    }

    @Override
    public Client getByEmail(String email)
    {
        return clientDao.getByUsername(email);
    }

    public List<Client> getAll()
    {
        List<Client> list = clientDao.getAll();
        Collections.reverse(list);
        return list;
    }

    public void add(Client client)
    {
        clientDao.add(client);
    }
}
