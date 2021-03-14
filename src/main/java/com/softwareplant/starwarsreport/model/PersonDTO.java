package com.softwareplant.starwarsreport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {

        private long id;
        private String name;
        private String homeworld;
        private String[] films;
        private String url;
}
