package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Film;
import com.softwareplant.starwarsreport.model.rest.DTOWrapper;
import com.softwareplant.starwarsreport.model.rest.FilmDTO;
import com.softwareplant.starwarsreport.utils.Utils;
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
public class FilmService {

    @Value("${api.url}")
    private String baseUrl;

    public Film getFilmByUrl(String url) {
        FilmDTO filmDTO = getFilmDTOByUrl(url);
        return mapToFilm(filmDTO);
    }

    public List<Film> getFilms() {
        List<FilmDTO> filmDTOS = getFilmsDTO();
        return filmDTOS.stream().map(this::mapToFilm).collect(Collectors.toList());
    }

    public FilmDTO getFilmDTOByUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FilmDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    private List<FilmDTO> getFilmsDTO() {
        String filmsUrl = "films/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DTOWrapper<FilmDTO>> response = restTemplate.exchange(
                baseUrl + filmsUrl,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                }
        );
        return Objects.requireNonNull(response.getBody()).getResults();
    }

    private Film mapToFilm(FilmDTO filmDTO) {
        return Film.builder()
                .id(Utils.getIdFromUrl(filmDTO.getUrl()))
                .name(filmDTO.getTitle())
                .url(filmDTO.getUrl())
                .build();
    }
}
