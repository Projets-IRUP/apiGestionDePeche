package com.Anthony.apiGestionDePeche.service;

import com.Anthony.apiGestionDePeche.modele.Sortie;
import java.util.List;

public interface SortieService { 

    Sortie creer(Sortie sortie);
    List<Sortie> lire();
    Sortie modifier(Integer id, Sortie sortie);
    String supprimer(Integer id);
}
