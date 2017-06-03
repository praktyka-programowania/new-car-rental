package service.impl;


import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService
{
    @Autowired
    private ClientService clientService;

    public Client get(int id)
    {
        return clientService.get(id);
    }

    public List<Client> getAll()
    {
        return clientService.getAll();
    }

    public void add(Client client)
    {
        clientService.add(client);
    }
}
