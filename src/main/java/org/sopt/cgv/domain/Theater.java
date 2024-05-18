package org.sopt.cgv.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class Theater {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;

    private String theaterName;

    private int maxSeats;

    private String theaterType;

    private LocalTime startAt;

    private LocalTime endAt;

    private int remainingSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
}
