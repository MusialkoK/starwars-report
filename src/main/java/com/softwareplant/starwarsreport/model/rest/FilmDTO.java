package com.softwareplant.starwarsreport.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FilmDTO extends DTO{

    private Long id;
    private String name;
    private String url;
}
