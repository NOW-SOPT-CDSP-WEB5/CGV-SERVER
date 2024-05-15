package org.sopt.cgv.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.cgv.service.HeartsService;
import org.sopt.cgv.service.MovieService;
import org.sopt.cgv.service.dto.MovieDetailRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController implements MovieControllerSwagger {

    private final MovieService movieService;
    private final HeartsService heartsService;

    @GetMapping("/{movieId}/details")
    public ResponseEntity<MovieDetailRequestDto> getMovieDetail(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(movieService.findMovieDetailById(movieId));
    }

    @PostMapping("/{movieId}/hearts")
    public ResponseEntity likeMovie(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", heartsService.addHearts(movieId))
                .build();
    }

    @DeleteMapping("/{movieId}/hearts")
    public ResponseEntity unlikeMovie(
            @PathVariable Long movieId
    ) {
        heartsService.deleteHearts(movieId);
        return ResponseEntity.noContent().build();
    }
}
