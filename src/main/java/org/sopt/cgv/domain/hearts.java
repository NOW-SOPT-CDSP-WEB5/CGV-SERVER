package org.sopt.cgv.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class hearts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Movie movie;

    @Builder
    private hearts(Movie movie) {
        this.movie = movie;
    }

    public static hearts create(Movie movie) {
        return hearts.builder()
                .movie(movie)
                .build();
    }
}
