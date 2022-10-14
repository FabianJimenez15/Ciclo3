package com.mintic.Reto3.Repository.Crud;

import com.mintic.Reto3.Model.Reservation;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ReservationCrudRepositoryInterfaz extends CrudRepository <Reservation, Integer >{

//JPQL JAVA PERSISTENCE QUERY LANGUAGE
    @Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countTotalReservationByClient();

    //public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservation>  findAllByStatus(String status);
}
