package com.softwareplant.starwarsreport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Report {

    @Id
    private Long id;
    private String characterPhrase;
    private String planetName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ReportResult> resultList;
}
