package com.Anthony.apiGestionDePeche.controller;

import com.Anthony.apiGestionDePeche.dto.LeurreStatistiqueDTO;
import com.Anthony.apiGestionDePeche.service.StatistiqueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StatistiqueController {

    private final StatistiqueService statistiqueService;

    @GetMapping("/statistique/leurres")
    public List<LeurreStatistiqueDTO> getLeurreStatistics(@RequestParam int year) {
        return statistiqueService.getLeurreStatisticsForYear(year);
    }
}
