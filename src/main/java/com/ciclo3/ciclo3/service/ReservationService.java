package com.ciclo3.ciclo3.service;

import com.ciclo3.ciclo3.model.Reservation;
import com.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(Integer id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> auxReservation = reservationRepository.getReservation(reservation.getIdReservation());
            if (auxReservation.isEmpty()){
                return reservationRepository.save(reservation);
            } else return reservation;
        }
    }
}
