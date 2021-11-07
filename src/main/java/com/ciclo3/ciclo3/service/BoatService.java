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
        if(boat.getId()!=null){
            Optional<Boat> e = boatRepository.getBoat(boat.getId());
            if(!e.isEmpty()){
                if(boat.getName()!=null){
                    e.get().setName(boat.getName());
                }
                if(boat.getBrand()!=null){
                    e.get().setBrand(boat.getBrand());
                }
                if(boat.getYear()!=null){
                    e.get().setYear(boat.getYear());
                }
                if(boat.getDescription()!=null){
                    e.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory()!=null){
                    e.get().setCategory(boat.getCategory());
                }
                boatRepository.save(e.get());
                return e.get();
            }else{
                return boat;
            }
        }else{
            return boat;
        }
    }

    

}
