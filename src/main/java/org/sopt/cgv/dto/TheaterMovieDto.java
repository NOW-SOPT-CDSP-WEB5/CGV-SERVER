package org.sopt.cgv.dto;

import org.sopt.cgv.domain.Movie;
import org.sopt.cgv.domain.Theater;

import java.util.List;
import java.util.stream.Collectors;

public record TheaterMovieDto (
        Long movieId,
        String movieName,
        String movieRating,
        List<TheaterCinemaDto> cinemas
){

    public static TheaterMovieDto of(Movie movie, List<Theater> theaters){
        return new TheaterMovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getFilmRatings(),
                theaters.stream().
                        collect(Collectors.groupingBy(Theater::getCinema))
                        .entrySet()
                        .stream()
                        .map(entry ->
                                TheaterCinemaDto.of(entry.getKey(), entry.getValue()))
                        .collect(Collectors.toList())
        );
    }
}
