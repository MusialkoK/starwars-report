package com.softwareplant.starwarsreport.factories;

import com.softwareplant.starwarsreport.model.Report;
import com.softwareplant.starwarsreport.model.rest.ReportQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;

@Service
public class ReportFactory {

    public Report create(Long id, ReportQuery query){
        return Report.builder()
                .id(id)
                .characterPhrase(query.getCharacterPhrase())
                .planetName(query.getPlanetName())
                .resultList(Collections.emptyList())
                .build();
    }
}
