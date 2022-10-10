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

    public Client updateClient(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> client_update = clientRepository.getClientId(client.getIdClient());
            if (!client_update.isEmpty()) {
                if (client.getName() != null) {
                    client_update.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    client_update.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    client_update.get().setPassword(client.getPassword());
                }
                if (client.getEmail() != null) {
                    client_update.get().setEmail(client.getEmail());
                }

                return clientRepository.saveClient(client_update.get());
            }
        }
        return client;
    }

    public boolean deleteClient(Integer clientId) {
        boolean flag = false;
        Optional<Client> client_d = clientRepository.getClientId(clientId);
        if (client_d.isPresent()) {
            clientRepository.deleteClient(client_d.get());
            flag = true;
        }
        return flag;
    }

}
