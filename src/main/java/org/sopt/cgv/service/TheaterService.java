package org.sopt.cgv.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.cgv.domain.Theater;
import org.sopt.cgv.dto.TheaterTopDto;
import org.sopt.cgv.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterTopDto findTheaterList(List<Long> movies, List<Long> cinemas) {
        return TheaterTopDto.of(
                theaterRepository.findAllWithMovieAndCinemaByMovieIdsAndCinemaIds(movies, cinemas)
        );
    }
}
