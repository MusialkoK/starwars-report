package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Planet;
import com.softwareplant.starwarsreport.model.rest.PlanetDTO;
import com.softwareplant.starwarsreport.services.rest.PlanetDTOService;
import com.softwareplant.starwarsreport.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlanetService {

    private final PlanetDTOService planetDTOService;

    public Planet getPlanetByUrl(String url) {
        PlanetDTO planetDTO = planetDTOService.getPlanetDTOByUrl(url);
        return mapToPlanet(planetDTO);
    }

    private Planet mapToPlanet(PlanetDTO planetDTO) {
        return Planet.builder()
                .id(Utils.getIdFromUrl(planetDTO.getUrl()))
                .name(planetDTO.getName())
                .url(planetDTO.getUrl())
                .build();
    }
}
