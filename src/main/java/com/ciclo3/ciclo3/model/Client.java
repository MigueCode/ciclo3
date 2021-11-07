package com.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;
}
