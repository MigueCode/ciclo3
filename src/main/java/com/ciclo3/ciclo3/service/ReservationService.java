package com.ciclo3.ciclo3.service;

import com.ciclo3.ciclo3.model.Reservation;
import com.ciclo3.ciclo3.model.assets.ReservationStatus;
import com.ciclo3.ciclo3.model.assets.TopClients;
import com.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
/**
 * Esta clase es el servicio de Reservation
 */
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Este metodo obtiene toda la lista de reservaciones
     * @return
     */
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    /**
     * Este metodo obtiene una reservacion por id
     * @param id
     * @return
     */
    public Optional<Reservation> getReservation(Integer id){
        return reservationRepository.getReservation(id);
    }

    /**
     * Este metodo guarda una reservacion
     * @param reservation
     * @return
     */
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

    /**
     * Este metodo obtiene el estado de la reservacion
     * @return
     */
    public ReservationStatus reservationStatus(){
        List<Reservation> reservationsCompleted = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> reservationsCancelled = reservationRepository.getReservationsByStatus(("cancelled"));
        return new ReservationStatus(reservationsCompleted.size(),reservationsCancelled.size());
    }

    /**
     * Este metodo obtiene la fecha de la reservacion
     * @param a
     * @param b
     * @return
     */
    public List<Reservation> reservationsByPeriod(String a, String b){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date dateOne = new Date();
        Date dateTwo = new Date();

        try {
            dateOne = parser.parse(a);
            dateTwo = parser.parse(b);
        } catch (ParseException error){
            error.printStackTrace();
        }

        if (dateOne.before(dateTwo)){
            return reservationRepository.getAllReservationsByDate(dateOne, dateTwo);
        } else return new ArrayList<>();

    }

    /**
     * Esta clase obtiene los clientes top
     * @return
     */
    public List<TopClients> topClients(){
        return reservationRepository.topClients();
    }
}
