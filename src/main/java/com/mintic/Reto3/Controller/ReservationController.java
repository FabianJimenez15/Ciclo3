package com.mintic.Reto3.Controller;

import com.mintic.Reto3.Model.Reservation;
import com.mintic.Reto3.Service.ReservationService;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService  ReservationService;
    
    @GetMapping("/all")
    public List <Reservation> getReservationAll(){
            return ReservationService.getReservationAll();
    }
    @GetMapping("/id")
    public Optional <Reservation> getReservationId(@PathVariable("id")Integer identificador){
        return ReservationService.getReservationId(identificador);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation reservation){
        return ReservationService.saveReservation(reservation);
    }

     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return ReservationService.updateReservation(reservation);
    } 
   
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation (@PathVariable("id")Integer reservationId){
        return ReservationService.deleteReservation(reservationId);
    }
}
