package org.sopt.cgv.service.dto;

import org.sopt.cgv.domain.Movie;

public record MovieDetailRequestDto (
        String title,
        String script
) {
    public static MovieDetailRequestDto of(Movie movie) {
        return new MovieDetailRequestDto(movie.getTitle(), movie.getScript());
    }
}
