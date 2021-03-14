package com.softwareplant.starwarsreport.model;

import lombok.Data;

import java.util.List;

@Data
public class PeopleDTO {

    private int count;
    private String next;
    private String previous;
    private List<PersonDTO> results;
}
