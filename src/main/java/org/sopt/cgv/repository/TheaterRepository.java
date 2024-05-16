package org.sopt.cgv.repository;

import org.sopt.cgv.domain.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
