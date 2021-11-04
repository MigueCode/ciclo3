package com.ciclo3.ciclo3.controller;

import com.ciclo3.ciclo3.model.Boat;
import com.ciclo3.ciclo3.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boat")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BoatController {

    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    public List<Boat> getAll(){
        return boatService.getAll();
    }

    @GetMapping("/{id]")
    public Optional<Boat> getBoat(@PathVariable("id") Integer id){
        return boatService.getBoat(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boat){
        return boatService.save(boat);
    }

}
