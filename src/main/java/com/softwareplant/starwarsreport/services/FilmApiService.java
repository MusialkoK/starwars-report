package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.FilmDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmApiService {

    private String url = "http://192.168.99.100:8080/api/films";

    public FilmDTO getFilm(Long id){
        url += "/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FilmDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                }
        );
        response.getBody().setId(id);
        return response.getBody();
    }
}
