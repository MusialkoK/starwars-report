package com.softwareplant.starwarsreport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    private Long id;
    private String characterPhrase;
    private String planetName;
    @OneToMany
    private List<ReportResult> resultList;
}
