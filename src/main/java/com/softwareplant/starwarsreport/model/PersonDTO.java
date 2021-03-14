package com.softwareplant.starwarsreport.model;

import lombok.Data;

@Data
public class PersonDTO {

        private String name;
        private String homeworld;
        private String[] films;
        private String url;
}
