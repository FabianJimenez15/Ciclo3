package com.mintic.Reto3.Repository;

import com.mintic.Reto3.Model.Client;
import com.mintic.Reto3.Repository.Crud.ClientCrudRepositoryInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepositoryInterfaz clientCrudRepositoryInterfaz;
    
    public List <Client> getClientAll(){
        return (List<Client>) clientCrudRepositoryInterfaz.findAll();
        
    }
    public Optional <Client> getClientId(Integer id){
        return clientCrudRepositoryInterfaz.findById(id);
        }
    
    public Client saveClient(Client client){
        return  clientCrudRepositoryInterfaz.save(client);
    }
}