package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Planet;
import com.softwareplant.starwarsreport.model.rest.PlanetDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PlanetServiceTest {

    @InjectMocks
    private PlanetService planetService;

    @Test
    void getPlanetByUrl() {
        PlanetDTO planetDTO = new PlanetDTO().setName("Tatooine").setUrl("/1");
        Planet planet = new Planet(1,"Tatooine","/1");
        PlanetService mockedPlanetService = Mockito.spy(planetService);
        Mockito.doReturn(planetDTO).when(mockedPlanetService).getPlanetDTOByUrl("/1");

        Planet result = mockedPlanetService.getPlanetByUrl("/1");
        assertEquals(result,planet);
    }
}
