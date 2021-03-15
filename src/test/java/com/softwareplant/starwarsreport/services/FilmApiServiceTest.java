package com.softwareplant.starwarsreport.services;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

class FilmApiServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"1:A New Hope", "2:The Empire Strikes Back", "3:Return of the Jedi",
            "4:The Phantom Menace", "5:Attack of the Clones", "6:Revenge of the Sith"}, delimiter = ':')
    void checkTitle(String input, String expected) {
        FilmApiService filmApiService = new FilmApiService();
        assertEquals(filmApiService.getFilm(Long.parseLong(input)).getTitle(), expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5", "6:6"}, delimiter = ':')
    void checkId(String input, String expected) {
        FilmApiService filmApiService = new FilmApiService();
        assertEquals(filmApiService.getFilm(Long.parseLong(input)).getId(), Long.parseLong(expected));
    }
}
