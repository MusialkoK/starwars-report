package com.softwareplant.starwarsreport.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO extends DTO{

    private String name;
    @JsonProperty("homeworld")
    private String homeworldUrl;
    @JsonProperty("films")
    private List<String> filmsUrl;
    private String url;

}
