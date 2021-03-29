package com.softwareplant.starwarsreport.services.rest;

import com.softwareplant.starwarsreport.model.Person;
import com.softwareplant.starwarsreport.model.rest.DTOWrapper;
import com.softwareplant.starwarsreport.model.rest.PersonDTO;
import com.softwareplant.starwarsreport.model.rest.ReportQuery;
import com.softwareplant.starwarsreport.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class PersonDTOService {

    @Value("${api.url}")
    private String baseUrl;

    private final String peopleUrl = "/people";

    public List<PersonDTO> getPeopleDTO() {
        RestTemplate restTemplate = new RestTemplate();
        String currentURL = baseUrl + peopleUrl;
        List<PersonDTO> result = new ArrayList<>();
        do {
            ResponseEntity<DTOWrapper<PersonDTO>> response = restTemplate.exchange(
                    currentURL,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    new ParameterizedTypeReference<>() {
                    }
            );
            List<PersonDTO> newEntries = Objects.requireNonNull(response.getBody()).getResults();
            result.addAll(newEntries);
            if (response.getBody().getNext() != null) {
                currentURL = response.getBody().getNext();
            } else break;
        } while (true);
        return result;
    }
}
