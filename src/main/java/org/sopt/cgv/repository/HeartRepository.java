package org.sopt.cgv.repository;

import org.sopt.cgv.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {

    Optional<Heart> findByMovieId(Long movieId);
}
