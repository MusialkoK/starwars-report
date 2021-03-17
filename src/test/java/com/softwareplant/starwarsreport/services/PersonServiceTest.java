package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Film;
import com.softwareplant.starwarsreport.model.Person;
import com.softwareplant.starwarsreport.model.Planet;
import com.softwareplant.starwarsreport.model.rest.PersonDTO;
import com.softwareplant.starwarsreport.model.rest.ReportQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;
    @Mock
    private PlanetService planetService;
    @Mock
    private FilmService filmService;

    @Test
    void filteredPeopleList() {
        PersonDTO p1 = new PersonDTO("R3-D3","/1", List.of("film1", "film2"),"id/1");
        PersonDTO p2 = new PersonDTO("R2-D2","/2", List.of("film1", "film2"),"id/2");
        Planet planet1 = new Planet(1L,"Tattoine","/1");
        Planet planet2 = new Planet(2L,"Naboo","/2");
        Film film1 = new Film(1,"A New Hope","/1");
        Film film2 = new Film(2,"The Last Jedi","/2");


        ReportQuery query = new ReportQuery("R","Naboo");
        PersonService mockedPersonService = Mockito.spy(personService);

        Person person = new Person(2L,"R2-D2",planet2,List.of(film1, film2),"id/2");


        Mockito.doReturn(List.of(p1,p2)).when(mockedPersonService).getPeopleDTO();
        when(planetService.getPlanetByUrl("/1")).thenReturn(planet1);
        when(planetService.getPlanetByUrl("/2")).thenReturn(planet2);
        when(filmService.getFilmByUrl("film1")).thenReturn(film1);
        when(filmService.getFilmByUrl("film2")).thenReturn(film2);

        List<Person> result = mockedPersonService.filteredPeopleList(query);
        assertEquals(List.of(person),result);
    }

    @Test
    void filteredPeopleListNoMocks() {

        ReportQuery query = new ReportQuery("R","Tatooine");
        List<Person> result = personService.filteredPeopleList(query);
        assertNotEquals(result, Collections.emptyList());
    }
}
