package com.Anthony.apiGestionDePeche.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LeurreStatistiqueDTO {
    private String nomLeurre;
    private Long nombreDePrises;
}
