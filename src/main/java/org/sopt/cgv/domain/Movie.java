package org.sopt.cgv.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private float reservationRate;

    private float eggRate;

    private float goldenEggRate;

    private LocalDate releaseDate;

    private String filmRatings;

    private String imageUrl;

    private String genres;

    private String theaterType;

    @Column(columnDefinition = "TEXT")
    private String script;

    private int rank;
}
