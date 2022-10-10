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

    public Reservation updateReservation(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservation_update = ReservationRepository.getReservationId(reservation.getIdReservation());
            if (!reservation_update.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    reservation_update.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservation_update.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reservation_update.get().setStatus(reservation.getStatus());
                }
                return ReservationRepository.saveReservation(reservation_update.get());
            }
        }
        return reservation;
    }

    public boolean deleteReservation(Integer reservationId){
        boolean flag=false;
        Optional<Reservation> reservation_d=ReservationRepository.getReservationId(reservationId);
        if(reservation_d.isPresent()){
            ReservationRepository.deleteReservation(reservation_d.get());
            flag=true;
            }
            return flag;
    }
}