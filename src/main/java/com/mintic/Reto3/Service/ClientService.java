package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Client;
import com.mintic.Reto3.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClientAll() {
        return clientRepository.getClientAll();
    }

    public Optional<Client> getClientId(Integer id) {
        return clientRepository.getClientId(id);
    }

    public Client saveClient(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.saveClient(client);
        } else {
            Optional<Client> clienteAuxiliar = clientRepository.getClientId(client.getIdClient());
            if (clienteAuxiliar.isEmpty()) {
                return clientRepository.saveClient(client);
            } else {
                return client;
            }
        }
    }
}
