package com.Anthony.apiGestionDePeche.controller;

import com.Anthony.apiGestionDePeche.service.PoissonService;

import jakarta.websocket.server.PathParam;

import com.Anthony.apiGestionDePeche.modele.Poisson;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/poisson")
@AllArgsConstructor
public class PoissonController {

    private final PoissonService poissonService;

    @PostMapping("/create")
    public Poisson create(@RequestBody  Poisson poisson){
        return poissonService.creer(poisson);
    }

    @GetMapping ("/read")
    public List<Poisson> read(){
        return poissonService.lire();
    }
    
    @PutMapping("/update/{id}")
    public Poisson update (@PathVariable Integer id,@RequestBody Poisson poisson){
        return poissonService.modifier(id, poisson);
    }

    @DeleteMapping ("/delete/{id}")
    public String delete (@PathVariable Integer id){
        return poissonService.supprimer(id);
    }
    
}