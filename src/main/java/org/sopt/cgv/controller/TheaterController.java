package org.sopt.cgv.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.cgv.dto.TheaterTopDto;
import org.sopt.cgv.service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TheaterController {

    private final TheaterService theaterService;

    @GetMapping("/theaters")
    public ResponseEntity<TheaterTopDto> getTheaterList(
            @RequestParam(value = "movie", required = false) final List<Long> movies,
            @RequestParam(value = "cinema", required = false) final List<Long> cinemas
    ) {
        return ResponseEntity.ok(theaterService.findTheaterList(movies, cinemas));
    }
}
