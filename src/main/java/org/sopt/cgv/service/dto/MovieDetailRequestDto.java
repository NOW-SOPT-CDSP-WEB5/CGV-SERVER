package org.sopt.cgv.service.dto;

import org.sopt.cgv.domain.Movie;

public record MovieDetailRequestDto (
        String title,
        String script,
        boolean isLiked
) {
    public static MovieDetailRequestDto of(Movie movie, boolean isLiked) {
        return new MovieDetailRequestDto(movie.getTitle(), movie.getScript(), isLiked);
    }
}
