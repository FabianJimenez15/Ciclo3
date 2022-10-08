package com.mintic.Reto3.Service;

import com.mintic.Reto3.Model.Reservation;
import com.mintic.Reto3.Repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository  ReservationRepository;
    
    public  List <Reservation> getReservationAll(){
    return ReservationRepository.getReservationAll();
    }
    
    public Optional <Reservation> getReservationId(Integer id){
    return ReservationRepository.getReservationId(id);
    }
    public Reservation saveReservation (Reservation reservation){
        if(reservation.getIdReservation()== null){
            return ReservationRepository.saveReservation(reservation);
        }else{
            Optional <Reservation> reservationAuxiliar =ReservationRepository.getReservationId(reservation.getIdReservation());
            if(reservationAuxiliar.isEmpty()){
            return  ReservationRepository.saveReservation(reservation);
            }else{
            return reservation;
            }
        }
    }
}