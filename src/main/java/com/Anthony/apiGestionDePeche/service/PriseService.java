package com.Anthony.apiGestionDePeche.service;

import com.Anthony.apiGestionDePeche.modele.Prise;
import java.util.List;

public interface PriseService { 

    Prise creer(Prise prise);
    List<Prise> lire();
    Prise modifier(Integer id, Prise prise);
    String supprimer(Integer id);
}
