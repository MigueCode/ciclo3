package com.ciclo3.ciclo3.service;

import com.ciclo3.ciclo3.model.Client;
import com.ciclo3.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(Integer idClient){
        return clientRepository.getClient(idClient);
    }


}
