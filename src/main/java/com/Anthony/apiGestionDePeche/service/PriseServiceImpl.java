package com.Anthony.apiGestionDePeche.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Anthony.apiGestionDePeche.modele.Prise;
import com.Anthony.apiGestionDePeche.repository.PriseRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriseServiceImpl implements PriseService {

    private final PriseRepository priseRepository;

    @Override
    public Prise creer(Prise prise) {
        return priseRepository.save(prise);
    }

    @Override
    public List<Prise> lire() {
        return priseRepository.findAll();
    }

    @Override
    public Prise modifier(Integer id, Prise prise) {
        return priseRepository.findById(id)
            .map(p -> {
                p.setTaille(prise.getTaille());
                p.setPoids(prise.getPoids());
                p.setRemarque(prise.getRemarque());
                p.setPoisson(prise.getPoisson());
                p.setLeurre(prise.getLeurre());
                p.setSortie(prise.getSortie());
                return priseRepository.save(p);
            })
            .orElseThrow(() -> new RuntimeException("Prise non trouvée"));
    }

    @Override
    public String supprimer(Integer id) {
        priseRepository.deleteById(id);
        return "Prise supprimée";
    }
}
