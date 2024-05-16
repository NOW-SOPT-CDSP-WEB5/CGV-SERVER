package org.sopt.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cgv.domain.Movie;
import org.sopt.cgv.repository.MovieRepository;
import org.sopt.cgv.service.dto.MovieDetailRequestDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository MovieRepository;

    public Movie findById(Long movieId) {
        return MovieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화를 찾을 수 없습니다.")
        );
    }

    public MovieDetailRequestDto findMovieDetailById(Long movieId) {
        return MovieDetailRequestDto.of(findById(movieId));
    }
}
