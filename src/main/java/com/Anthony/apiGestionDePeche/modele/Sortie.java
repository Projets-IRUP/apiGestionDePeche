package com.Anthony.apiGestionDePeche.modele;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "sortie")
@Getter
@Setter
@NoArgsConstructor
public class Sortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSortie;
    private LocalDateTime dateHeure;
    private String spot;
    private String meteo;
    private Boolean maree;
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "sortie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore  // Ignore the 'prises' field during serialization
    private Set<Prise> prises;
}
