package com.Anthony.apiGestionDePeche.controller;

import com.Anthony.apiGestionDePeche.modele.Prise;
import com.Anthony.apiGestionDePeche.service.PriseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prise")
@AllArgsConstructor
public class PriseController {

    private final PriseService priseService;

    @PostMapping("/create")
    public Prise create(@RequestBody Prise prise) {
        return priseService.creer(prise);
    }

    @GetMapping("/read")
    public List<Prise> read() {
        return priseService.lire();
    }

    @PutMapping("/update/{id}")
    public Prise update(@PathVariable Integer id, @RequestBody Prise prise) {
        return priseService.modifier(id, prise);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return priseService.supprimer(id);
    }
}
