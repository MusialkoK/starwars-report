package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Planet;
import com.softwareplant.starwarsreport.model.rest.DTOWrapper;
import com.softwareplant.starwarsreport.model.rest.PlanetDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    private final String URL = "http://192.168.99.100:8080/api/planets";

    public List<Planet> getPlanets() {
        RestTemplate restTemplate = new RestTemplate();
        String currentURL = URL;
        List<Planet> result = new ArrayList<>();
        do {
            ResponseEntity<DTOWrapper<PlanetDTO>> response = restTemplate.exchange(
                    currentURL,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    new ParameterizedTypeReference<>() {
                    }
            );
            List<PlanetDTO> newEntries = Objects.requireNonNull(response.getBody()).getResults();
            newEntries.forEach(e -> {
                String[] splicedUrl = e.getUrl().split("/");
                e.setId(Integer.parseInt(splicedUrl[splicedUrl.length - 1]));
            });
            result.addAll(mapToPlanet(newEntries));
            if (response.getBody().getNext() != null) {
                currentURL = response.getBody().getNext();
            } else break;
        } while (true);

        return result;
    }

    private Planet mapToPlanet(PlanetDTO planetDTO){
        return new Planet(planetDTO.getId(), planetDTO.getName(), planetDTO.getUrl());
    }

    private List<Planet> mapToPlanet(List<PlanetDTO> planetsDTO){
        return planetsDTO.stream().map(this::mapToPlanet).collect(Collectors.toList());
    }

    public Planet getPlanetByName(String planetName) {
        return new Planet();
    }
}
