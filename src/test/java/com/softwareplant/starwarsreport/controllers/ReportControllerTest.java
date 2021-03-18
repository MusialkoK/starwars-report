package com.softwareplant.starwarsreport.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.softwareplant.starwarsreport.model.rest.ReportQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReportController reportController;

    @Test
    void putCorrectReport() throws Exception {
        //given
        String phrase = "ann";
        String planet = "Tatooine";
        Long inputId = 1L;
        ReportQuery query = new ReportQuery(phrase, planet);
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        //when+then
        mockMvc.perform(MockMvcRequestBuilders
                .put("/reports/{id}", inputId)
                .content(objectWriter.writeValueAsString(query))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void successfullyDeleteSingleReport() throws Exception {
        //given
        Long inputId = 1L;
        String phrase = "ann";
        String planet = "Tatooine";
        ReportQuery query = new ReportQuery(phrase, planet);
        reportController.putReport(inputId,query);


        //when+then
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/reports/{id}", inputId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void unsuccessfullyDeleteSingleReport() throws Exception {
        //given
        Long inputId = 1L;
        Long deleteId = 2L;
        String phrase = "ann";
        String planet = "Tatooine";
        ReportQuery query = new ReportQuery(phrase, planet);
        reportController.putReport(inputId,query);


        //when+then
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/reports/{id}", deleteId))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void deleteReports() throws Exception {
        //given

        //when+then
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/reports/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getReport() throws Exception {
        //given
        Long inputId = 1L;

        //when+then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/reports/{id}", inputId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getReports() throws Exception {
        //given

        //when+then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/reports/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}
