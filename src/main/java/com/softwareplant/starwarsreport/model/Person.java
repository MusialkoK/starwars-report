package com.softwareplant.starwarsreport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private long id;
    private String name;
    private Planet homeworld;
    private List<Film> filmList;
    private String url;
}
