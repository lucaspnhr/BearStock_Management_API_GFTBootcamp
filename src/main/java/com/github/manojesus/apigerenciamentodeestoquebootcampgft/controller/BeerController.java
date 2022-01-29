package com.github.manojesus.apigerenciamentodeestoquebootcampgft.controller;

import com.github.manojesus.apigerenciamentodeestoquebootcampgft.DTO.BeerDTO;
import com.github.manojesus.apigerenciamentodeestoquebootcampgft.exception.BeerAlreadyExistsException;
import com.github.manojesus.apigerenciamentodeestoquebootcampgft.exception.BeerNotFoundException;
import com.github.manojesus.apigerenciamentodeestoquebootcampgft.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController {

    private final BeerService beerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDTO saveBeerToDB(@RequestBody @Valid BeerDTO beerDTO) throws BeerAlreadyExistsException {
        return beerService.create(beerDTO);
    }

    @GetMapping("/{beerName}")
    public BeerDTO getBeerByName(@PathVariable String beerName) throws BeerNotFoundException {
        return beerService.searchBeerByName(beerName);
    }

}