package org.sopt.cgv.dto;

import org.sopt.cgv.domain.Cinema;
import org.sopt.cgv.domain.Theater;

import java.util.List;
import java.util.stream.Collectors;

public record TheaterCinemaDto (
        Long cinemaId,
        String cinemaName,
        Double distance,
        List<TheaterDto> theaters
) {

        public static TheaterCinemaDto of(Cinema cinema, List<Theater> theaters){
            return new TheaterCinemaDto(
                    cinema.getId(),
                    cinema.getName(),
                    cinema.getDistance(),
                    theaters.stream()
                            .collect(Collectors.groupingBy(Theater::getTheaterName))
                            .values()
                            .stream()
                            .map(theaterList -> TheaterDto.of(theaterList.get(0), theaterList))
                            .collect(Collectors.toList())
            );
        }
}
