package org.sopt.cgv.repository;

import org.sopt.cgv.domain.Hearts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartsRepository extends JpaRepository<Hearts, Long> {

    Optional<Hearts> findByMovieId(Long movieId);
}
