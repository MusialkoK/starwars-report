package com.softwareplant.starwarsreport.services;

import com.softwareplant.starwarsreport.model.Planet;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    public Planet getPlanetByName(String planetName) {
        return new Planet();
    }
}
