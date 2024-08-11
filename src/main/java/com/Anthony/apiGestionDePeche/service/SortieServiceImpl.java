package com.Anthony.apiGestionDePeche.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Anthony.apiGestionDePeche.modele.Sortie;
import com.Anthony.apiGestionDePeche.repository.SortieRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SortieServiceImpl implements SortieService {

    private final SortieRepository sortieRepository;

    @Override
    public Sortie creer(Sortie sortie) {
        return sortieRepository.save(sortie);
    }

    @Override
    public List<Sortie> lire() {
        return sortieRepository.findAll();
    }

    @Override
    public Sortie modifier(Integer id, Sortie sortie) {
        return sortieRepository.findById(id)
            .map(s -> {
                s.setDateHeure(sortie.getDateHeure());
                s.setSpot(sortie.getSpot());
                s.setMeteo(sortie.getMeteo());
                s.setMaree(sortie.getMaree());
                s.setCommentaire(sortie.getCommentaire());
                s.setUtilisateur(sortie.getUtilisateur());
                return sortieRepository.save(s);
            })
            .orElseThrow(() -> new RuntimeException("Sortie non trouvée"));
    }

    @Override
    public String supprimer(Integer id) {
        sortieRepository.deleteById(id);
        return "Sortie supprimée";
    }
}
