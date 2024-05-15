package org.sopt.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cgv.domain.Movie;
import org.sopt.cgv.repository.HeartsRepository;
import org.sopt.cgv.repository.MovieRepository;
import org.sopt.cgv.repository.TicketRepository;
import org.sopt.cgv.service.dto.MovieDetailRequestDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository MovieRepository;
    private final HeartsRepository heartsRepository;
    private final TicketRepository ticketRepository;

    public Movie findById(Long movieId) {
        return MovieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화를 찾을 수 없습니다.")
        );
    }

    public MovieDetailRequestDto findMovieDetailById(Long movieId) {
        Movie movie = findById(movieId);
        boolean isLiked = heartsRepository.findByMovieId(movieId).isPresent();
        boolean isTicketed = !ticketRepository.findByMovieId(movieId).isEmpty();
        return MovieDetailRequestDto.of(movie, isLiked, isTicketed);
    }
}
