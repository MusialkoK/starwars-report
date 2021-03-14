package com.softwareplant.starwarsreport.controllers;

import com.softwareplant.starwarsreport.services.PersonDTOService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/people")
@AllArgsConstructor
public class PersonController {

    private final PersonDTOService personDTOService;

    @GetMapping
    public String getPeople(){
        personDTOService.getPeople();
        return "";
    }

}
