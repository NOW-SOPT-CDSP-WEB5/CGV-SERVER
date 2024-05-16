package org.sopt.cgv.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Movie movie;

    @Builder
    private Heart(Movie movie) {
        this.movie = movie;
    }

    public static Heart create(Movie movie) {
        return Heart.builder()
                .movie(movie)
                .build();
    }
}
