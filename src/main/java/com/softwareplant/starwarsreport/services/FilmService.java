package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Film;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    public Film getFilmByUrl(String url) {
        return new Film();
    }
}
