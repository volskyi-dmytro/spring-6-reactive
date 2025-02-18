package com.stpunk47.spring_6_reactive.controllers;

import com.stpunk47.spring_6_reactive.model.BeerDTO;
import com.stpunk47.spring_6_reactive.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class BeerController {

    public static final String BEER_PATH = "/api/v2/beer";

    private final BeerService beerService;


    @GetMapping(BEER_PATH)
    Flux<BeerDTO> listBeers(){

        return beerService.listBeers();
    }

}
