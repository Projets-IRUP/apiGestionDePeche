package com.Anthony.apiGestionDePeche.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prise")
@Getter
@Setter
@NoArgsConstructor
public class Prise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrise;
    private double taille;
    private Double poids;
    private String remarque;

    @ManyToOne
    @JoinColumn(name = "id_poisson", nullable = false)
    private Poisson poisson;

    @ManyToOne
    @JoinColumn(name = "id_leurre", nullable = false)
    private Leurre leurre;

    @ManyToOne
    @JoinColumn(name = "id_sortie", nullable = false)
    private Sortie sortie;
}
