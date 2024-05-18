package org.sopt.cgv.dto;

import java.time.LocalTime;

public record TheaterTimeDto(
        LocalTime startAt,
        LocalTime endAt,
        int remainingSeats
) {
    public static TheaterTimeDto of(LocalTime startAt, LocalTime endAt, int remainingSeats){
        return new TheaterTimeDto(startAt, endAt, remainingSeats);
    }
}
