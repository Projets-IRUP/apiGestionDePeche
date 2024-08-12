package com.Anthony.apiGestionDePeche.repository;

import com.Anthony.apiGestionDePeche.modele.Prise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriseRepository extends JpaRepository<Prise, Integer> {
    @Query("SELECT p.leurre.nom, COUNT(p) as priseCount FROM Prise p WHERE YEAR(p.sortie.dateHeure) = :year GROUP BY p.leurre.nom ORDER BY priseCount DESC")
    List<Object[]> findLeurreStatisticsForYear(@Param("year") int year);
}
