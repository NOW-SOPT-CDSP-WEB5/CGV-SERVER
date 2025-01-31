package org.sopt.cgv.repository;

import org.sopt.cgv.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByOrderByRank();
}
