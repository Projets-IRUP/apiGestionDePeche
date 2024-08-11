package com.Anthony.apiGestionDePeche.service;

import com.Anthony.apiGestionDePeche.modele.Poisson;
import java.util.List;

public interface PoissonService { 

    Poisson creer(Poisson poisson);
    List<Poisson> lire();
    Poisson modifier(Integer id, Poisson poisson);
    String supprimer(Integer id);
    
}
