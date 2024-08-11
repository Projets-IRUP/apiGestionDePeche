package com.Anthony.apiGestionDePeche.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Anthony.apiGestionDePeche.modele.Poisson;
import com.Anthony.apiGestionDePeche.repository.PoissonRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class PoissonServiceImpl implements PoissonService {

    private final PoissonRepository poissonRepository;
    @Override
    public Poisson creer(Poisson poisson) {
        // TODO Auto-generated method stub
      return poissonRepository.save(poisson);
    }

    @Override
    public List<Poisson> lire() {
        // TODO Auto-generated method stub
       return poissonRepository.findAll();
    }

    @Override
    public Poisson modifier(Integer id, Poisson poisson) {
        // TODO Auto-generated method stub
        return poissonRepository.findById(id)
        .map(p->{ p.setNom(poisson.getNom());
        return poissonRepository.save(p);
    }).orElseThrow(()->new RuntimeException("Poisson non trouvé"));
    }

    @Override
    public String supprimer(Integer id) {
        // TODO Auto-generated method stub
        poissonRepository.deleteById(id);
        return "Poisson supprimé";
    }
    
}
