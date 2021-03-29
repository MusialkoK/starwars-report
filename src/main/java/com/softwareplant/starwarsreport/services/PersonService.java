package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Person;
import com.softwareplant.starwarsreport.model.rest.PersonDTO;
import com.softwareplant.starwarsreport.model.rest.ReportQuery;
import com.softwareplant.starwarsreport.services.rest.PersonDTOService;
import com.softwareplant.starwarsreport.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonDTOService personDTOService;
    private final PlanetService planetService;
    private final FilmService filmService;

    public List<Person> filteredPeopleList(ReportQuery query) {

        List<PersonDTO> peopleDTO = personDTOService.getPeopleDTO().stream()
                .filter(p -> matchesNamePhrase(p, query.getCharacterPhrase()))
                .filter(p -> planetService.getPlanetByUrl(p.getHomeworldUrl()).getName().equals(query.getPlanetName()))
                .collect(Collectors.toList());

        return peopleDTO.stream()
                .map(this::mapToPerson)
                .collect(Collectors.toList());
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
