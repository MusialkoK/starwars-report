package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Person;
import com.softwareplant.starwarsreport.model.rest.ReportQuery;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonService {

    public List<Person> filteredPeopleList(ReportQuery query){
        return Collections.emptyList();
    }
}
