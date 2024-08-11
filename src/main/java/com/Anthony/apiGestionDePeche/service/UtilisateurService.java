package com.Anthony.apiGestionDePeche.service;

import com.Anthony.apiGestionDePeche.modele.Utilisateur;
import java.util.List;

public interface UtilisateurService { 

    Utilisateur creer(Utilisateur utilisateur);
    List<Utilisateur> lire();
    Utilisateur modifier(Integer id, Utilisateur utilisateur);
    String supprimer(Integer id);
}
