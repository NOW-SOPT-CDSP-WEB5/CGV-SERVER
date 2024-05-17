package org.sopt.cgv.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.sopt.cgv.domain.Movie;

import java.time.LocalDate;

public record MovieDto (
        Long id,
        String name,
        Float reservationRate,
        Float eggRate,
        Float GoldenEggRate,
        @JsonFormat(pattern = "yyyy.MM.dd")
        LocalDate releaseDate,
        String filmRatings,
        String imageUrl,
        String genres,
        String theaterType
) {
    public static MovieDto of(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getReservationRate(),
                movie.getEggRate(),
                movie.getGoldenEggRate(),
                movie.getReleaseDate(),
                movie.getFilmRatings(),
                movie.getImageUrl(),
                movie.getGenres(),
                movie.getTheaterType()
        );
    }
}
