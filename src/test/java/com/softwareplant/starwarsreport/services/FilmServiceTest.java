package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Film;
import com.softwareplant.starwarsreport.model.rest.FilmDTO;
import com.softwareplant.starwarsreport.services.rest.FilmDTOService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FilmServiceTest {

    @Mock
    private FilmDTOService filmDTOService;

    @InjectMocks
    private FilmService filmService;

    @Test
    void getFilmByUrl() {
        String url = "/1";
        String name = "A new Hope";
        FilmDTO filmDTO = new FilmDTO().setTitle(name).setUrl("/1");
        Film film = new Film(1, name, "/1");
        Mockito.when(filmDTOService.getFilmDTOByUrl(url)).thenReturn(filmDTO);
        Film result = filmService.getFilmByUrl("/1");
        assertEquals(result, film);
    }
}
