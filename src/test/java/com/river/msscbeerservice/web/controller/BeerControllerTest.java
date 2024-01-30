package com.river.msscbeerservice.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.river.msscbeerservice.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

/**
 * BeerControllerTest
 */
@Slf4j
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        log.info("running getBeerById");
        mockMvc.perform(get(String.format("/api/v1/beer/%s", UUID.randomUUID().toString())).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        log.info("running saveNewBeer");
        mockMvc.perform(post("/api/v1/beer")
               .contentType(MediaType.APPLICATION_JSON)
               .content(beerDtoJson))
            .andExpect(status().isCreated());
            
    }

    @Test
    void updateBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        log.info("running updateBeer");
        mockMvc.perform(put(String.format("/api/v1/beer/%s", UUID.randomUUID().toString()))
               .contentType(MediaType.APPLICATION_JSON)
               .content(beerDtoJson))
            .andExpect(status().isNoContent());
    }
}
