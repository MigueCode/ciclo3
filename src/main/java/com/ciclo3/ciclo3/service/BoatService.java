package com.ciclo3.ciclo3.service;

import com.ciclo3.ciclo3.model.Boat;
import com.ciclo3.ciclo3.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> getAll(){
        return boatRepository.getAll();
    }

    public Optional<Boat> getBoat(Integer id){
        return boatRepository.getBoat(id);
    }

    public Boat save(Boat boat){
        if (boat.getId() == null){
            return boatRepository.save(boat);
        } else {
            Optional<Boat> boatAux = boatRepository.getBoat(boat.getId());
            if (boatAux.isEmpty()){
                return boatRepository.save(boat);
            } else return boat;
        }
    }

    public Boat update(Boat boat){
        if (boat.getId() != null){
            Optional<Boat> auxBoat = boatRepository.getBoat(boat.getId());
            if (auxBoat.isPresent()){
                if (boat.getName() != null){
                    auxBoat.get().setName(boat.getName());
                }
                if (boat.getBrand() != null){
                    auxBoat.get().setBrand(boat.getBrand());
                }
                if (boat.getDescription() != null){
                    auxBoat.get().setDescription(boat.getDescription());
                }
                if (boat.getYear() != null){
                    auxBoat.get().setYear(boat.getYear());
                }

                return boatRepository.save(auxBoat.get());
            }
        }

        return boat;
    }

    public boolean delete(Integer id){
        Optional<Boat> boatAux = boatRepository.getBoat(id);
        if (boatAux.isPresent()){
            boatRepository.delete(boatAux.get());
            return true;
        }
        return false;
    }
}
