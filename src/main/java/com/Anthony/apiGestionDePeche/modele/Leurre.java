package com.Anthony.apiGestionDePeche.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "leurre")
@Getter
@Setter
@NoArgsConstructor
public class Leurre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLeurre;
    private String nom;
    private double taille;
    private String coloris;
    private double grammage;
    private String type;
}
