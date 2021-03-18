package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Planet;
import com.softwareplant.starwarsreport.model.rest.PlanetDTO;
import com.softwareplant.starwarsreport.utils.Utils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetService {

    public Planet getPlanetByUrl(String url) {
        PlanetDTO planetDTO = getPlanetDTOByUrl(url);
        return mapToPlanet(planetDTO);
    }

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

    private Planet mapToPlanet(PlanetDTO planetDTO) {
        return Planet.builder()
                .id(Utils.getIdFromUrl(planetDTO.getUrl()))
                .name(planetDTO.getName())
                .url(planetDTO.getUrl())
                .build();
    }
}
