package org.sopt.cgv.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Theater theater;

    private Long movieId;

    @Builder
    private Ticket(Theater theater) {
        this.theater = theater;
        this.movieId = theater.getMovie().getId();
    }

    public static Ticket create(Theater theater) {
        return Ticket.builder()
                .theater(theater)
                .build();
    }
}
