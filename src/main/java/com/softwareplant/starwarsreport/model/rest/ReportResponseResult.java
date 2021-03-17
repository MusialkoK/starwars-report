package com.softwareplant.starwarsreport.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ReportResponseResult {

    @JsonProperty("film_id")
    private Long filmId;
    @JsonProperty("film_name")
    private String filmName;
    @JsonProperty("character_id")
    private Long characterId;
    @JsonProperty("character_name")
    private String characterName;
    @JsonProperty("planet_id")
    private Long planetId;
    @JsonProperty("planet_name")
    private String planetName;
}
