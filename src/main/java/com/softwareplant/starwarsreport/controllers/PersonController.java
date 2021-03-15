package com.softwareplant.starwarsreport.controllers;

import com.softwareplant.starwarsreport.services.PersonApiService;
import com.softwareplant.starwarsreport.services.PlanetApiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/people")
@AllArgsConstructor
public class PersonController {

    private final PlanetApiService personApiService;

    @GetMapping
    public String getPeople(){
        personApiService.getPlanets();
        return "";
    }

}
