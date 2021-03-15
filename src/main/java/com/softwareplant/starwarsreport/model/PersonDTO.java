package com.softwareplant.starwarsreport.model;

import lombok.Data;

@Data
public class PersonDTO extends DTO{

        private long id;
        private String name;
        private String homeworld;
        private String[] films;
        private String url;
}
