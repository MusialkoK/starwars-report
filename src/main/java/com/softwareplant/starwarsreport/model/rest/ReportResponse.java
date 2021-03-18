package com.softwareplant.starwarsreport.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ReportResponse {

    @JsonProperty("report_id")
    private Long id;
    @JsonProperty("query_criteria_character_phrase")
    private String characterPhrase;
    @JsonProperty("query_criteria_planet_name")
    private String planetName;
    @JsonProperty("result")
    private List<ReportResponseResult> resultList;

}
