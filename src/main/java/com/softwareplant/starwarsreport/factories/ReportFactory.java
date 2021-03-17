package com.softwareplant.starwarsreport.factories;

import com.softwareplant.starwarsreport.model.Person;
import com.softwareplant.starwarsreport.model.Planet;
import com.softwareplant.starwarsreport.model.Report;
import com.softwareplant.starwarsreport.model.ReportResult;
import com.softwareplant.starwarsreport.model.rest.ReportQuery;
import com.softwareplant.starwarsreport.services.PersonService;
import com.softwareplant.starwarsreport.services.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportFactory {

    private final PersonService personService;
    private final PlanetService planetService;

    public Report create(Long id, ReportQuery query){
        List<ReportResult> resultList = new ArrayList<>();
        Planet planet = planetService.getPlanetByName(query.getPlanetName());

        List<Person> characterList = personService.filteredPeopleList(query.getCharacterPhrase(), planet.getUrl());

        characterList.forEach(p-> p.getFilmList().forEach(f->{
            ReportResult result = ReportResult.builder()
                    .characterName(p.getName())
                    .characterId(p.getId())
                    .planetId(p.getHomeworld().getId())
                    .planetName(p.getHomeworld().getName())
                    .filmName(f.getName())
                    .filmId(f.getId())
                    .build();
            resultList.add(result);
        }));


        return Report.builder()
                .id(id)
                .characterPhrase(query.getCharacterPhrase())
                .planetName(query.getPlanetName())
                .resultList(resultList)
                .build();
    }
}
