package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.PeopleDTO;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class PeopleServiceTest {

    @Test
    void getPeopleConnection() {
        //given
        String url = "http://192.168.99.100:8080/api/people";
        //when
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PeopleDTO> exchange = restTemplate.exchange(
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
        String url = "http://192.168.99.100:8080/api/people";
        PeopleService peopleService = new PeopleService();
        //when
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PeopleDTO> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<>() {
                });
        //then
        assertEquals(peopleService.getPeople().size(), Objects.requireNonNull(exchange.getBody()).getCount());
    }
}
