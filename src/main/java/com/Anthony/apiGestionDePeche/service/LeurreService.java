package com.Anthony.apiGestionDePeche.service;

import com.Anthony.apiGestionDePeche.modele.Leurre;
import java.util.List;

public interface LeurreService { 

    Leurre creer(Leurre leurre);
    List<Leurre> lire();
    Leurre modifier(Integer id, Leurre leurre);
    String supprimer(Integer id);
}
