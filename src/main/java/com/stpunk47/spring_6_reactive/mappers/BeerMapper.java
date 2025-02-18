package com.stpunk47.spring_6_reactive.mappers;

import com.stpunk47.spring_6_reactive.domain.Beer;
import com.stpunk47.spring_6_reactive.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDTOtoBeer(BeerDTO dto);

    BeerDTO beerToBeerDTO(Beer beer);
}
