package com.mintic.Reto3.Controller;

import com.mintic.Reto3.Model.Skate;
import com.mintic.Reto3.Service.SkateService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class SkateController {

    @Autowired
    private SkateService skateService;

    @GetMapping("/all")
    public List<Skate> getSkateALL() {
        return skateService.getSkateAll();
    }

    @GetMapping("/id")
    public Optional<Skate> getSkateId(@PathVariable("id") Integer identificador) {
        return skateService.getSkateId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate saveSkate(@RequestBody Skate skate) {
        return skateService.saveSkate(skate);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate update(@RequestBody Skate skate) {
        return skateService.updateSkate(skate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteClient(@PathVariable("id") Integer skateId) {
        return skateService.deleteSkate(skateId);
    }
}