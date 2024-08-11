package com.Anthony.apiGestionDePeche.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Anthony.apiGestionDePeche.modele.Utilisateur;
import com.Anthony.apiGestionDePeche.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur creer(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> lire() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur modifier(Integer id, Utilisateur utilisateur) {
        return utilisateurRepository.findById(id)
            .map(u -> {
                u.setNom(utilisateur.getNom());
                u.setPrenom(utilisateur.getPrenom());
                u.setIdentifiant(utilisateur.getIdentifiant());
                u.setMotDePasse(utilisateur.getMotDePasse());
                return utilisateurRepository.save(u);
            })
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    @Override
    public String supprimer(Integer id) {
        utilisateurRepository.deleteById(id);
        return "Utilisateur supprimé";
    }
}
