package com.softwareplant.starwarsreport.model;

import lombok.Data;

import java.util.List;

@Data
public class DTOWrapper<T extends DTO> {

    private int count;
    private String next;
    private String previous;
    private List<T> results;

}
