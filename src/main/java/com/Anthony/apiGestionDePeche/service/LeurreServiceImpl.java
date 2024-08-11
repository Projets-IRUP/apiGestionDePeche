package com.Anthony.apiGestionDePeche.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Anthony.apiGestionDePeche.modele.Leurre;
import com.Anthony.apiGestionDePeche.repository.LeurreRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LeurreServiceImpl implements LeurreService {

    private final LeurreRepository leurreRepository;

    @Override
    public Leurre creer(Leurre leurre) {
        return leurreRepository.save(leurre);
    }

    @Override
    public List<Leurre> lire() {
        return leurreRepository.findAll();
    }

    @Override
    public Leurre modifier(Integer id, Leurre leurre) {
        return leurreRepository.findById(id)
            .map(l -> {
                l.setNom(leurre.getNom());
                l.setTaille(leurre.getTaille());
                l.setColoris(leurre.getColoris());
                l.setGrammage(leurre.getGrammage());
                l.setType(leurre.getType());
                return leurreRepository.save(l);
            })
            .orElseThrow(() -> new RuntimeException("Leurre non trouvé"));
    }

    @Override
    public String supprimer(Integer id) {
        leurreRepository.deleteById(id);
        return "Leurre supprimé";
    }
}
