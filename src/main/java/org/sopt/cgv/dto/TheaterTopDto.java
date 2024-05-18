package org.sopt.cgv.dto;

import org.sopt.cgv.domain.Theater;

import java.util.List;
import java.util.stream.Collectors;

public record TheaterTopDto (
        List<TheaterMovieDto> movies
){
    public static TheaterTopDto of(List<Theater> theaters){
        return new TheaterTopDto(
                theaters.stream()
                        .collect(Collectors.groupingBy(Theater::getMovie))
                        .entrySet()
                        .stream()
                        .map(entry ->
                                TheaterMovieDto.of(entry.getKey(), entry.getValue()))
                        .collect(Collectors.toList())

        );
    }
}
