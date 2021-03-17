package com.softwareplant.starwarsreport.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ReportQuery {
    @JsonProperty("query_criteria_character_phrase")
    private String characterPhrase;
    @JsonProperty("query_criteria_planet_name")
    private String planetName;
}
