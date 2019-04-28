package ro.ubb.bookstore.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.bookstore.common.domain.Client;
import ro.ubb.bookstore.common.service.ClientService;
import ro.ubb.bookstore.server.repository.ClientRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClientServiceS implements ClientService
{
    private static final Logger log = LoggerFactory.getLogger(ClientServiceS.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void addClient(Client client)
    {
        log.trace("addClient: client = {}",client);

        clientRepository.save(client);

        log.trace("addClient --- method finished");
    }

    @Override
    public void removeClient(Long id)
    {
        log.trace("removeClient: id = {}",id);

        clientRepository.deleteById(id);

        log.trace("removeClient --- method finished");
    }

    @Override
    public void updateClient(Client client)
    {
        log.trace("updateClient: client = {}",client);

        clientRepository.findById(client.getId()).ifPresent((client1 ->
        {
            client1.setName(client.getName());
            client1.setGender(client.getGender());
            client1.setAge(client.getAge());
            clientRepository.save(client1);

            log.debug("updateClient --- client updated? --- client = {}",client1);
        }));

        log.trace("updateClient --- method finished");
    }

    @Override
    public Set<Client> getAllClients()
    {
        log.trace("getAllClients --- method entered");
        return new HashSet<>(clientRepository.findAll());
    }
}
