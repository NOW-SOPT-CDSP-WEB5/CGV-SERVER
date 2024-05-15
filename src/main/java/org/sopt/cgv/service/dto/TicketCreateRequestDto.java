package org.sopt.cgv.service.dto;

public record TicketCreateRequestDto(
        Long theaterId
) {
    public static TicketCreateRequestDto of(Long theaterId) {
        return new TicketCreateRequestDto(theaterId);
    }
}
