package com.softwareplant.starwarsreport.factories;

import com.softwareplant.starwarsreport.model.Report;
import com.softwareplant.starwarsreport.model.ReportResult;
import com.softwareplant.starwarsreport.model.rest.ReportResponse;
import com.softwareplant.starwarsreport.model.rest.ReportResponseResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportResponseFactory {

    public ReportResponse create(Report report){
        List<ReportResponseResult> results = report.getResultList().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return mapToResponse(report,results);
    }

    private ReportResponseResult mapToResponse(ReportResult reportResult){
        return ReportResponseResult.builder()
                .characterId(reportResult.getCharacterId())
                .characterName(reportResult.getCharacterName())
                .filmId(reportResult.getFilmId())
                .filmName(reportResult.getFilmName())
                .planetId(reportResult.getPlanetId())
                .planetName(reportResult.getPlanetName())
                .build();
    }

    private ReportResponse mapToResponse(Report report, List<ReportResponseResult> results){
        return ReportResponse.builder()
                .id(report.getId())
                .characterPhrase(report.getCharacterPhrase())
                .planetName(report.getPlanetName())
                .resultList(results).build();
    }
}
