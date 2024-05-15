package org.sopt.cgv.service.dto;

import org.sopt.cgv.domain.Movie;

public record MovieDetailRequestDto (
        String title,
        String script,
        boolean isLiked,
        boolean isticketd
) {
    public static MovieDetailRequestDto of(Movie movie, boolean isLiked, boolean isTicketd) {
        return new MovieDetailRequestDto(movie.getTitle(), movie.getScript(), isLiked, isTicketd);
    }
}
