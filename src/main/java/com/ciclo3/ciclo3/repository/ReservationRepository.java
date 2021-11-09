package com.ciclo3.ciclo3.repository;

import com.ciclo3.ciclo3.model.Client;
import com.ciclo3.ciclo3.model.Reservation;
import com.ciclo3.ciclo3.model.assets.TopClients;
import com.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(Integer id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getAllReservationsByDate(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<TopClients> topClients(){
        List<TopClients> result = new ArrayList<>();

        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();

        for (Integer i = 0; i < report.size(); i ++){
            result.add(new TopClients((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }



        return result;
    }


}
