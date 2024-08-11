package com.Anthony.apiGestionDePeche.repository;

import com.Anthony.apiGestionDePeche.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
