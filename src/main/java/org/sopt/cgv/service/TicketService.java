package org.sopt.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cgv.domain.Theater;
import org.sopt.cgv.domain.Ticket;
import org.sopt.cgv.repository.TheaterRepository;
import org.sopt.cgv.repository.TicketRepository;
import org.sopt.cgv.service.dto.TicketCreateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TheaterRepository theaterRepository;

    @Transactional
    public String buyTicket(Long movieId, TicketCreateRequestDto ticketCreateRequestDto) {
        Theater theater = theaterRepository.findById(ticketCreateRequestDto.theaterId())
                .orElseThrow(() -> new IllegalArgumentException("해당 영화를 상영하는 상영관을 찾을 수 없습니다.")
                );
        Ticket ticket = Ticket.create(theater);
        ticketRepository.save(ticket);
        return ticket.getId().toString();
    }
}
