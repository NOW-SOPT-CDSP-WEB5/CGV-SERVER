package org.sopt.cgv.dto;

import org.sopt.cgv.domain.Movie;

import java.util.List;

public record MoviesDto (
        List<MovieDto> movies
){

    public static MoviesDto of(final List<Movie> movies) {
        return new MoviesDto(
                movies.stream()
                        .map(MovieDto::of)
                        .toList()
        );
    }
}
