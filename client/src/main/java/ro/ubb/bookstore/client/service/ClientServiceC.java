package ro.ubb.bookstore.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.bookstore.common.domain.Client;
import ro.ubb.bookstore.common.domain.valdator.ValidatorException;
import ro.ubb.bookstore.common.service.ClientService;

import java.util.Set;

public class ClientServiceC implements ClientService
{
    @Autowired
    private ClientService clientService;

    @Override
    public void addClient(Client client) throws ValidatorException
    {
        clientService.addClient(client);
    }

    @Override
    public void removeClient(Long id)
    {
        clientService.removeClient(id);
    }

    @Override
    public void updateClient(Client client)
    {
        clientService.updateClient(client);
    }

    @Override
    public Set<Client> getAllClients()
    {
        return clientService.getAllClients();
    }
}
