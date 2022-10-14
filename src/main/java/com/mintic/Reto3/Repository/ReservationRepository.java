package com.mintic.Reto3.Repository;

import com.mintic.Reto3.Model.Client;
import com.mintic.Reto3.Model.Reservation;
import com.mintic.Reto3.Model.Custom.CountClient;
import com.mintic.Reto3.Repository.Crud.ReservationCrudRepositoryInterfaz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepositoryInterfaz reservationCrudRepositoryInterfaz;

    public List<Reservation> getReservationAll() {
        return (List<Reservation>) reservationCrudRepositoryInterfaz.findAll();
    }

    public Optional<Reservation> getReservationId(Integer id) {
        return reservationCrudRepositoryInterfaz.findById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationCrudRepositoryInterfaz.save(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        reservationCrudRepositoryInterfaz.delete(reservation);
    }

    public List<Reservation> getReservationByStatus(String status) {
        return reservationCrudRepositoryInterfaz.findAllByStatus(status);

        }
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepositoryInterfaz.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<CountClient> getTopClient(){
        List<CountClient> res=new ArrayList<>();

        List<Object[]> report=reservationCrudRepositoryInterfaz.countTotalReservationByClient();

        for(int i=0; i<report.size();i++){
            Client client=(Client) report.get(i)[0];
            Long cantidad=(Long) report.get(i)[1];
            CountClient cc=new CountClient(cantidad, client);
            res.add(cc);
             //res.add(new CountClient ((Long) report.get(i)[1],(Client)report.get(i)[0]));
        }

        return res;
    }

}