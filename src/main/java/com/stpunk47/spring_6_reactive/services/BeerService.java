package com.stpunk47.spring_6_reactive.services;

import com.stpunk47.spring_6_reactive.model.BeerDTO;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BeerService {

    Flux<BeerDTO> listBeers();

    Mono<BeerDTO> getBeerById(Integer beerId);

    Mono<BeerDTO> saveNewBeer(BeerDTO beerDTO);

    Mono<BeerDTO> updateBeer(Integer beerId, BeerDTO beerDTO);
}
