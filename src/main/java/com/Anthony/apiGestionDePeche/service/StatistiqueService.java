package com.Anthony.apiGestionDePeche.service;

import java.util.List;

public interface StatistiqueService {

    List<LeurreStatistiqueDTO> getLeurreStatisticsForYear(int year);
}
