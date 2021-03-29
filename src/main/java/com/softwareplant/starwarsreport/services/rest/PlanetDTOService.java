package com.softwareplant.starwarsreport.services.rest;

import com.softwareplant.starwarsreport.model.rest.PlanetDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetDTOService {

    public PlanetDTO getPlanetDTOByUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PlanetDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }
}
