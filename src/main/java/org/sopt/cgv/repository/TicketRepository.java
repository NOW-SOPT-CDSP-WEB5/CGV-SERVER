package org.sopt.cgv.repository;

import org.sopt.cgv.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByMovieId(Long movieId);
}
