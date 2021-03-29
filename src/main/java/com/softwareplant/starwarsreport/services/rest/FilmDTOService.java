package com.softwareplant.starwarsreport.services.rest;

import com.softwareplant.starwarsreport.model.rest.DTOWrapper;
import com.softwareplant.starwarsreport.model.rest.FilmDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service

public class FilmDTOService {
    @Value("${api.url}")
    private String baseUrl;

    public List<FilmDTO> getFilmsDTO() {
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
}
