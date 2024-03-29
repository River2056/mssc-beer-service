package com.river.msscbeerservice.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.river.msscbeerservice.web.model.BeerDto;

/**
 * BeerServiceController
 */
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
        // TODO impl getBeerById
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveNewBeer(@RequestBody BeerDto beerDto) {
        // TODO impl saveNewBeer
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Object> updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        // TODO impl updateBeer
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
