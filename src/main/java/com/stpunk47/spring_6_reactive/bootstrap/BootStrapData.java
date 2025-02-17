package com.stpunk47.spring_6_reactive.bootstrap;

import com.stpunk47.spring_6_reactive.domain.Beer;
import com.stpunk47.spring_6_reactive.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class BootStrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();

        beerRepository.count().subscribe(count -> {
            System.out.println("Count is: " + count);
        });
    }

    private void loadBeerData() {

        beerRepository.count().subscribe(count -> {
            if (count == 0) {
                Beer beer1 = Beer.builder()
                        .beerName("Obolon")
                        .beerStyle("Pale Ale")
                        .upc("1111")
                        .price(new BigDecimal("2.99"))
                        .quantityOnHand(22)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Beer beer2 = Beer.builder()
                        .beerName("Slavutych")
                        .beerStyle("IPA")
                        .upc("2222")
                        .price(new BigDecimal("1.99"))
                        .quantityOnHand(92)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Beer beer3 = Beer.builder()
                        .beerName("Rohan")
                        .beerStyle("Stout")
                        .upc("3333")
                        .price(new BigDecimal("3.99"))
                        .quantityOnHand(144)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                beerRepository.save(beer1).subscribe();
                beerRepository.save(beer2).subscribe();
                beerRepository.save(beer3).subscribe();
        }
        });
    }
}
