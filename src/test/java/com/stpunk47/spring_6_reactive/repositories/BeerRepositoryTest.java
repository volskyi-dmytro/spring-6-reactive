package com.stpunk47.spring_6_reactive.repositories;

import com.stpunk47.spring_6_reactive.config.DatabaseConfig;
import com.stpunk47.spring_6_reactive.domain.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataR2dbcTest
@Import(DatabaseConfig.class)
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void saveNewBeer() {
        beerRepository.save(getTestBeer())
                .subscribe(beer -> {
                    System.out.println(beer.toString());
                });
    }

    Beer getTestBeer() {
        return Beer.builder()
                .beerName("Dub")
                .beerStyle("Lager")
                .price(BigDecimal.TEN)
                .quantityOnHand(34)
                .upc("65464")
                .build();
    }
}