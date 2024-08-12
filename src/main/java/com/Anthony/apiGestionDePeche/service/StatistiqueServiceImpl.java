package com.Anthony.apiGestionDePeche.service;


import com.Anthony.apiGestionDePeche.dto.LeurreStatistiqueDTO;
import com.Anthony.apiGestionDePeche.repository.PriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StatistiqueServiceImpl implements StatistiqueService {

    private final PriseRepository priseRepository;

    @Override
    public List<LeurreStatistiqueDTO> getLeurreStatisticsForYear(int year) {
        List<Object[]> results = priseRepository.findLeurreStatisticsForYear(year);
        return results.stream()
                .map(result -> new LeurreStatistiqueDTO((String) result[0], (Long) result[1]))
                .collect(Collectors.toList());
    }
}
