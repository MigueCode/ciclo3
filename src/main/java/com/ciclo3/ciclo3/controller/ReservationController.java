package com.ciclo3.ciclo3.controller;

import com.ciclo3.ciclo3.model.Reservation;
import com.ciclo3.ciclo3.model.assets.ReservationStatus;
import com.ciclo3.ciclo3.model.assets.TopClients;
import com.ciclo3.ciclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") Integer id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @GetMapping("/report-status")
    public ReservationStatus reservationStatus(){
        return reservationService.reservationStatus();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> resrvationsByDate(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.reservationsByPeriod(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<TopClients> topClients(){
        return reservationService.topClients();
    }
}
