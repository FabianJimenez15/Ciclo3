package com.mintic.Reto3.Repository;

import com.mintic.Reto3.Model.Skate;
import com.mintic.Reto3.Repository.Crud.SkateCrudRepositoryInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SkateRepository {
    @Autowired
    private SkateCrudRepositoryInterfaz skateCrudRepositoryInterfaz ;
    
    public List <Skate> getSkateAll(){
    return  (List<Skate>) skateCrudRepositoryInterfaz.findAll();
    
    }
    public Optional <Skate> getSkateid(Integer id){
        return skateCrudRepositoryInterfaz.findById(id);
    
    }
    public Skate saveSkate(Skate skate){
        return  skateCrudRepositoryInterfaz.save(skate);
    }

    }