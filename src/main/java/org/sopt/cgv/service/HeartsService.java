package org.sopt.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cgv.domain.hearts;
import org.sopt.cgv.domain.Movie;
import org.sopt.cgv.repository.HeartsRepository;
import org.sopt.cgv.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HeartsService {

    private final HeartsRepository likeRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public String addHearts(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화를 찾을 수 없습니다.")
                );
        hearts like = hearts.create(movie);
        likeRepository.save(like);
        return like.getId().toString();
    }
}
