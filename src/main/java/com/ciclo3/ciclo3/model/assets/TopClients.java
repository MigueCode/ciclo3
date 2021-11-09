package com.ciclo3.ciclo3.model.assets;

import com.ciclo3.ciclo3.model.Reservation;

public class TopClients {

    private Long count;
    private Reservation reservation;

    public TopClients(Long count, Reservation reservation) {
        this.count = count;
        this.reservation = reservation;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
