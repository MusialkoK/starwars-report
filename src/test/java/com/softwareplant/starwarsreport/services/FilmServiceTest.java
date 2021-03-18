package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Film;
import com.softwareplant.starwarsreport.model.rest.FilmDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FilmServiceTest {

    @InjectMocks
    private FilmService filmService;

    @Test
    void getFilmByUrl() {
        FilmDTO filmDTO = new FilmDTO().setTitle("A New Hope").setUrl("/1");
        Film film = new Film(1,"A New Hope","/1");
        FilmService mockedFilmService = Mockito.spy(filmService);
        Mockito.doReturn(filmDTO).when(mockedFilmService).getFilmDTOByUrl("/1");

        Film result = mockedFilmService.getFilmByUrl("/1");

        assertEquals(result,film);

    }
}
