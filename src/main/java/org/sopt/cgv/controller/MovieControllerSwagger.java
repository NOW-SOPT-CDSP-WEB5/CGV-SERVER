package org.sopt.cgv.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.cgv.service.dto.MovieDetailRequestDto;
import org.sopt.cgv.service.dto.TicketCreateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "영화 API", description = "영화 관련 API")
public interface MovieControllerSwagger {

    @Operation(summary = "영화 세부 정보 조회 API")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieDetailRequestDto.class))),
            }
    )
    ResponseEntity<MovieDetailRequestDto> getMovieDetail(@PathVariable Long movieId);

    @Operation(summary = "영화 좋아요 클릭 API")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Like added successfully"),
                    @ApiResponse(responseCode = "404", description = "Movie not found")
    })
    ResponseEntity<Void> likeMovie(@PathVariable Long movieId);

    @Operation(summary = "영화 좋아요 삭제 API")
    ResponseEntity<Void> unlikeMovie(@PathVariable Long movieId);

    @Operation(summary = "영화 예매 API")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Ticket added successfully"),
                    @ApiResponse(responseCode = "404", description = "Theater not found")
            })
    ResponseEntity<Void> buyTicket(@PathVariable Long movieId, @RequestBody TicketCreateRequestDto ticketCreateRequestDto);

    @Operation(summary = "영화 예매 취소 API")
    ResponseEntity<Void> cancelTicket(@PathVariable Long movieId);

}
