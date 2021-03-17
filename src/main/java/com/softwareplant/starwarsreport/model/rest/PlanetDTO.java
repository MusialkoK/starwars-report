package com.softwareplant.starwarsreport.model.rest;

import lombok.Data;

@Data
public class PlanetDTO extends DTO{

    private long id;
    private String name;
    private String url;
}
