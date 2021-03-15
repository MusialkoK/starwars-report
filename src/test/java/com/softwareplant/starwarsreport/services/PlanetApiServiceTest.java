package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.DTOWrapper;
import com.softwareplant.starwarsreport.model.PlanetDTO;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PlanetApiServiceTest {

    String url = "http://192.168.99.100:8080/api/planets";
    RestTemplate restTemplate = new RestTemplate();

    @Test
    void getPeopleConnection() {
        //given

        //when
        ResponseEntity<DTOWrapper<PlanetDTO>> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                });
        //then
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        assertEquals(200, exchange.getStatusCodeValue());
    }

    @Test
    void getPeopleCount() {
        //given
        PlanetApiService planetApiService = new PlanetApiService();
        //when

        ResponseEntity<DTOWrapper<PlanetDTO>> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                });
        //then
        assertEquals(planetApiService.getPlanets().size(), Objects.requireNonNull(exchange.getBody()).getCount());
    }
}

