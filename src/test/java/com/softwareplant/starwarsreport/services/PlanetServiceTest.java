package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Planet;
import com.softwareplant.starwarsreport.model.rest.PlanetDTO;
import com.softwareplant.starwarsreport.services.rest.PlanetDTOService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlanetServiceTest {

    @Mock
    private PlanetDTOService planetDTOService;

    @InjectMocks
    private PlanetService planetService;

    @Test
    void getPlanetByUrl() {
        String url = "/1";
        String name = "Tatooine";
        PlanetDTO planetDTO = new PlanetDTO().setName(name).setUrl(url);
        Planet planet = new Planet(1,name,url);
        when(planetDTOService.getPlanetDTOByUrl(url)).thenReturn(planetDTO);
        Planet result = planetService.getPlanetByUrl(url);
        assertEquals(result,planet);
    }
}
