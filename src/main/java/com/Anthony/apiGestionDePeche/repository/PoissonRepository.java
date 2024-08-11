package com.Anthony.apiGestionDePeche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Anthony.apiGestionDePeche.modele.Poisson;

public interface PoissonRepository extends JpaRepository<Poisson,Integer>{

    
}