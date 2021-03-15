package com.softwareplant.starwarsreport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FilmDTO extends DTO{

    private long id;
    private String title;
}
