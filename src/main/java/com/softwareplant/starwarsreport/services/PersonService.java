package com.softwareplant.starwarsreport.services;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PlanetService planetService;
    private final FilmService filmService;

    @Value("${api.url}")
    private String baseUrl;

    private final String peopleUrl = "/people";

    public List<Person> filteredPeopleList(ReportQuery query) {
        List<PersonDTO> peopleDTO = getPeopleDTO().stream()
                .filter(p -> matchesNamePhrase(p, query.getCharacterPhrase()))
                .filter(p -> planetService.getPlanetByUrl(p.getHomeworldUrl()).getName().equals(query.getPlanetName()))
                .collect(Collectors.toList());

        return peopleDTO.stream()
                .map(this::mapToPerson)
                .collect(Collectors.toList());
    }


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

    private boolean matchesNamePhrase(PersonDTO personDTO, String phrase) {
        Pattern pattern = Pattern.compile(phrase);
        Matcher matcher = pattern.matcher(personDTO.getName());
        return matcher.find();
    }

    private Person mapToPerson(PersonDTO personDTO) {
        return Person.builder()
                .id(Utils.getIdFromUrl(personDTO.getUrl()))
                .name(personDTO.getName())
                .homeworld(planetService.getPlanetByUrl(personDTO.getHomeworldUrl()))
                .filmList(personDTO.getFilmsUrl().stream()
                        .map(filmService::getFilmByUrl)
                        .collect(Collectors.toList()))
                .url(personDTO.getUrl())
                .build();


    }
}
