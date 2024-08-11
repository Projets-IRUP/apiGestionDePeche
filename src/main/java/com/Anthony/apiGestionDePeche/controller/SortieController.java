package com.Anthony.apiGestionDePeche.controller;

import com.Anthony.apiGestionDePeche.modele.Sortie;
import com.Anthony.apiGestionDePeche.modele.Utilisateur;
import com.Anthony.apiGestionDePeche.repository.UtilisateurRepository;
import com.Anthony.apiGestionDePeche.service.SortieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sortie")
@AllArgsConstructor
public class SortieController {

    private final SortieService sortieService;
    private final UtilisateurRepository utilisateurRepository;

    @PostMapping("/create")
    public Sortie create(@RequestBody Sortie sortie) {
        // Récupérer l'utilisateur par son identifiant si nécessaire
        Utilisateur utilisateur = utilisateurRepository.findById(sortie.getUtilisateur().getIdUtilisateur())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        // Associer l'utilisateur à la sortie
        sortie.setUtilisateur(utilisateur);

        // Créer la sortie
        return sortieService.creer(sortie);
    }

    @GetMapping("/read")
    public List<Sortie> read() {
        return sortieService.lire();
    }

    @PutMapping("/update/{id}")
    public Sortie update(@PathVariable Integer id, @RequestBody Sortie sortie) {
        return sortieService.modifier(id, sortie);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return sortieService.supprimer(id);
    }
}
