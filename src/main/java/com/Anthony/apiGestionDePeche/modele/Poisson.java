package com.Anthony.apiGestionDePeche.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="poisson")
@Getter
@Setter
@NoArgsConstructor

public class Poisson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPoisson;
    
    @Column(length =  50)
    private String nom;
}
