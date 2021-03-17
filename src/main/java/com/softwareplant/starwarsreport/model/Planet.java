package com.softwareplant.starwarsreport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet {

    private long id;
    private String name;
    private String url;
}
