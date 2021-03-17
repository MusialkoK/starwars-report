package com.softwareplant.starwarsreport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private Long id;
    private String name;
    private Planet homeworld;
    private List<Film> filmList;
    private String url;
}
