package com.ciclo3.ciclo3.repository;

import com.ciclo3.ciclo3.model.Boat;
import com.ciclo3.ciclo3.repository.crud.BoatCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoatRepository {
    
    @Autowired
    private BoatCrudRepository boatCrudRepository;

    public List<Boat> getAll(){
        return (List<Boat>) boatCrudRepository.findAll();
    }

    public Optional<Boat> getBoat(Integer id){
        return boatCrudRepository.findById(id);
    }

    public Boat save(Boat boat){
        return boatCrudRepository.save(boat);
    }
    
    public void delete(Boat boat){
        boatCrudRepository.delete(boat);
    }
}
