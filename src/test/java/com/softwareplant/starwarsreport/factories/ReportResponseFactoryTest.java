package com.softwareplant.starwarsreport.factories;

import com.softwareplant.starwarsreport.model.Report;
import com.softwareplant.starwarsreport.model.ReportResult;
import com.softwareplant.starwarsreport.model.rest.ReportResponse;
import com.softwareplant.starwarsreport.model.rest.ReportResponseResult;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportResponseFactoryTest {

    @Test
    void isCreated() {
        //given

        ReportResponseFactory reportResponseFactory = new ReportResponseFactory();

        long filmId = 1L;
        String filmName = "A new Hope";
        String planetName = "Naboo";
        long planetId = 34L;
        long characterId = 12L;
        String characterName = "R2-D2";
        long reportId = 1L;
        String characterPhrase = "R";

        ReportResult reportResult = ReportResult.builder()
                .filmId(filmId)
                .filmName(filmName)
                .planetName(planetName)
                .planetId(planetId)
                .characterId(characterId)
                .characterName(characterName).build();

        Report report = Report.builder()
                .characterPhrase(characterPhrase)
                .planetName(planetName)
                .id(reportId)
                .resultList(List.of(reportResult))
                .build();

        ReportResponseResult responseResult = ReportResponseResult.builder()
                .planetName(planetName)
                .planetId(planetId)
                .filmName(filmName)
                .filmId(filmId)
                .characterName(characterName)
                .characterId(characterId)
                .build();

        ReportResponse expected = ReportResponse.builder()
                .resultList(List.of(responseResult))
                .planetName(planetName)
                .characterPhrase(characterPhrase)
                .id(reportId)
                .build();
        //when

        ReportResponse actual = reportResponseFactory.create(report);

        assertEquals(expected,actual);
        assertEquals(expected.getResultList(), actual.getResultList());

    }
}
