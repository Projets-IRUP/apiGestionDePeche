package com.Anthony.apiGestionDePeche.controller;

import com.Anthony.apiGestionDePeche.modele.Leurre;
import com.Anthony.apiGestionDePeche.service.LeurreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leurre")
@AllArgsConstructor
public class LeurreController {

    private final LeurreService leurreService;

    @PostMapping("/create")
    public Leurre create(@RequestBody Leurre leurre) {
        return leurreService.creer(leurre);
    }

    @GetMapping("/read")
    public List<Leurre> read() {
        return leurreService.lire();
    }

    @PutMapping("/update/{id}")
    public Leurre update(@PathVariable Integer id, @RequestBody Leurre leurre) {
        return leurreService.modifier(id, leurre);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return leurreService.supprimer(id);
    }
}
