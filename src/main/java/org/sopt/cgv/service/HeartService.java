package org.sopt.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cgv.domain.Heart;
import org.sopt.cgv.domain.Movie;
import org.sopt.cgv.repository.HeartRepository;
import org.sopt.cgv.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HeartService {

    private final HeartRepository heartRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public String addHearts(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화를 찾을 수 없습니다.")
                );
        Heart heart = Heart.create(movie);
        heartRepository.save(heart);
        return heart.getId().toString();
    }

    @Transactional
    public void deleteHearts(Long movieId) {
        Heart heart = heartRepository.findByMovieId(movieId)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화의 좋아요를 찾을 수 없습니다.")
                );
        heartRepository.delete(heart);
    }
}
