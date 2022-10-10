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

    public List<Skate> getSkateAll() {
        return skateRepository.getSkateAll();

    }

    public Optional<Skate> getSkateId(Integer id) {
        return skateRepository.getSkateid(id);
    }

    public Skate saveSkate(Skate skate) {
        if (skate.getId() == null) {
            return skateRepository.saveSkate(skate);
        } else {
            Optional<Skate> skateAuxiliar = skateRepository.getSkateid(skate.getId());
            if (skateAuxiliar.isEmpty()) {
                return skateRepository.saveSkate(skate);
            } else {
                return skate;
            }
        }
    }

    public Skate updateSkate(Skate skate) {
        if (skate.getId() != null) {
            Optional<Skate> skate_update = skateRepository.getSkateid(skate.getId());
            if (!skate_update.isEmpty()) {
                if (skate.getDescription() != null) {
                    skate_update.get().setDescription(skate.getDescription());
                }
                if (skate.getName() != null) {
                    skate_update.get().setName(skate.getName());
                }
                if (skate.getBrand() != null) {
                    skate_update.get().setBrand(skate.getBrand());
                }
                if (skate.getYear() != null) {
                    skate_update.get().setYear(skate.getYear());
                }
                return skateRepository.saveSkate(skate_update.get());
            }
        }
        return skate;
    }

    public boolean deleteSkate(Integer id) {
        Boolean skate_d = getSkateId(id).map(skate -> {
            skateRepository.deleteSkate(skate);
            return true;
        }).orElse(false);
        return skate_d;
    }

}
