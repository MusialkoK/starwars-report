package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Film;
import com.softwareplant.starwarsreport.model.rest.DTOWrapper;
import com.softwareplant.starwarsreport.model.rest.FilmDTO;
import com.softwareplant.starwarsreport.services.rest.FilmDTOService;
import com.softwareplant.starwarsreport.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmService {

    private final FilmDTOService filmDTOService;

    public Film getFilmByUrl(String url) {
        FilmDTO filmDTO = filmDTOService.getFilmDTOByUrl(url);
        return mapToFilm(filmDTO);
    }

    public List<Film> getFilms() {
        List<FilmDTO> filmDTOS = filmDTOService.getFilmsDTO();
        return filmDTOS.stream().map(this::mapToFilm).collect(Collectors.toList());
    }

    private Film mapToFilm(FilmDTO filmDTO) {
        return Film.builder()
                .id(Utils.getIdFromUrl(filmDTO.getUrl()))
                .name(filmDTO.getTitle())
                .url(filmDTO.getUrl())
                .build();
    }
}
