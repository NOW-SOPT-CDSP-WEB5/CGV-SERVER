package org.sopt.cgv.repository;

import org.sopt.cgv.domain.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

    @Query("SELECT t FROM Theater t JOIN FETCH t.movie m JOIN FETCH t.cinema c " +
            "WHERE m.id IN :movieIds AND c.id IN :cinemaIds")
    List<Theater> findAllWithMovieAndCinemaByMovieIdsAndCinemaIds(@Param("movieIds") List<Long> movieIds,
                                                                  @Param("cinemaIds") List<Long> cinemaIds);
}
