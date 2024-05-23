package org.sopt.cgv.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.cgv.dto.MoviesDto;
import org.sopt.cgv.service.HeartService;
import org.sopt.cgv.service.MovieService;
import org.sopt.cgv.service.TicketService;
import org.sopt.cgv.service.dto.MovieDetailRequestDto;
import org.sopt.cgv.service.dto.TicketCreateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MovieController implements MovieControllerSwagger {

    private final MovieService movieService;
    private final HeartService heartService;
    private final TicketService TicketService;

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<MovieDetailRequestDto> getMovieDetail(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(movieService.findMovieDetailById(movieId));
    }

    @PostMapping("/movies/{movieId}/hearts")
    public ResponseEntity<Void> likeMovie(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", heartService.addHearts(movieId))
                .build();
    }

    @DeleteMapping("/movies/{movieId}/hearts")
    public ResponseEntity<Void> unlikeMovie(
            @PathVariable Long movieId
    ) {
        heartService.deleteHearts(movieId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/movies/{movieId}/tickets")
    public ResponseEntity<Void> buyTicket(
            @PathVariable Long movieId,
            @RequestBody TicketCreateRequestDto ticketCreateRequestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", TicketService.buyTicket(movieId, ticketCreateRequestDto))
                .build();
    }

    @DeleteMapping("/movies/{movieId}/tickets")
    public ResponseEntity<Void> cancelTicket(
            @PathVariable Long movieId
    ) {
        TicketService.cancelTicket(movieId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/movies")
    public ResponseEntity<MoviesDto> getMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }
}
