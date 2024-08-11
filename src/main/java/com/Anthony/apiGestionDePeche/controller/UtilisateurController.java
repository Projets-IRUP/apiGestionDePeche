package com.Anthony.apiGestionDePeche.controller;

import com.Anthony.apiGestionDePeche.modele.Utilisateur;
import com.Anthony.apiGestionDePeche.service.UtilisateurService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @PostMapping("/create")
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.creer(utilisateur);
    }

    @GetMapping("/read")
    public List<Utilisateur> read() {
        return utilisateurService.lire();
    }

    @PutMapping("/update/{id}")
    public Utilisateur update(@PathVariable Integer id, @RequestBody Utilisateur utilisateur) {
        return utilisateurService.modifier(id, utilisateur);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return utilisateurService.supprimer(id);
    }
}
