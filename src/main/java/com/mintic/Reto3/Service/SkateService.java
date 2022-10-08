/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Skate;
import com.mintic.Reto3.Repository.SkateRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkateService {
    @Autowired
    private SkateRepository skateRepository;
    
    
    public List <Skate> getSkateAll(){
        return skateRepository.getSkateAll();
    
    }
    public Optional <Skate> getSkateId(Integer id){
        return skateRepository.getSkateid(id);
    }
    
    public Skate saveSkate (Skate skate){
        if (skate.getId()== null){
            return  skateRepository.saveSkate(skate);
        }
        else{
            Optional <Skate> skateAuxiliar= skateRepository.getSkateid(skate.getId());
            if(skateAuxiliar.isEmpty()){
            return skateRepository.saveSkate(skate);            
            }
            else{ 
            return skate;
           }
        }
    }
}
