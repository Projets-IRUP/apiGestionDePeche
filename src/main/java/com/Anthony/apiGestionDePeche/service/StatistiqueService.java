package com.Anthony.apiGestionDePeche.service;
import com.Anthony.apiGestionDePeche.dto.LeurreStatistiqueDTO;
import java.util.List;

public interface StatistiqueService {

    List<LeurreStatistiqueDTO> getLeurreStatisticsForYear(int year);
}
