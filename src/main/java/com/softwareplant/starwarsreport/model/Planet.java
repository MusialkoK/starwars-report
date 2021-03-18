package com.softwareplant.starwarsreport.model;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class Planet {

    private long id;
    private String name;
    private String url;
}
