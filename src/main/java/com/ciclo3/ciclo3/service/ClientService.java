package com.ciclo3.ciclo3.service;

import com.ciclo3.ciclo3.model.Category;
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

    public Optional<Client> getClient(Integer id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if (client.getIdClient() == null){
            return clientRepository.save(client);
        } else {
            Optional<Client> auxClient = clientRepository.getClient(client.getIdClient());
            if (auxClient.isEmpty()){
                return clientRepository.save(client);
            } else return client;
        }
    }

    public Client update(Client client){
        if (client.getIdClient() != null){
            Optional<Client> auxClient = clientRepository.getClient(client.getIdClient());
            if (auxClient.isPresent()){
                if (client.getEmail() != null){
                    auxClient.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null){
                    auxClient.get().setPassword(client.getPassword());
                }
                if (client.getName() != null){
                    auxClient.get().setName(client.getName());
                }
                if (client.getAge() != null){
                    auxClient.get().setAge(client.getAge());
                }
                return clientRepository.save(auxClient.get());
            }
        }
        return client;
    }

    public boolean delete(Integer id){
        Optional<Client> auxClient = clientRepository.getClient(id);
        if (auxClient.isPresent()){
            clientRepository.delete(auxClient.get());
            return true;
        }
        return false;
    }
}
