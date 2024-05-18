package org.sopt.cgv.dto;

import org.sopt.cgv.domain.Theater;

import java.util.List;

public record TheaterDto(
        Long theaterId,
        String theaterName,
        int maxSeats,
        String theaterType,
        List<TheaterTimeDto> times
) {
    public static TheaterDto of(Theater theater, List<Theater> theaters){
        return new TheaterDto(
                theater.getId(),
                theater.getTheaterName(),
                theater.getMaxSeats(),
                theater.getTheaterType(),
                theaters.stream()
                        .map(time -> TheaterTimeDto.of(time.getStartAt(), time.getEndAt(), time.getRemainingSeats()))
                        .toList()
        );
    }
}
