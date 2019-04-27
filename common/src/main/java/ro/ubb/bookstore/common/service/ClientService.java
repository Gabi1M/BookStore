package ro.ubb.bookstore.common.service;

import org.springframework.stereotype.Service;
import ro.ubb.bookstore.common.domain.Client;
import ro.ubb.bookstore.common.domain.valdator.ValidatorException;

import java.util.Set;

@Service
public interface ClientService
{
    void addClient(Client client) throws ValidatorException;

    void removeClient(Long id);

    void updateClient(Client client);

    Set<Client> getAllClients();
}
