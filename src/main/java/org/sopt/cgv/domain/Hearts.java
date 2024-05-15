package org.sopt.cgv.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Hearts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Movie movie;

    @Builder
    private Hearts(Movie movie) {
        this.movie = movie;
    }

    public static Hearts create(Movie movie) {
        return Hearts.builder()
                .movie(movie)
                .build();
    }
}
