package de.ait.timepad.controllers.api;
import de.ait.timepad.dto.events.EventDto;
import de.ait.timepad.dto.events.EventsDto;
import de.ait.timepad.dto.events.NewEventDto;
import de.ait.timepad.dto.events.UpdateEventDto;
import de.ait.timepad.dto.users.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tags(value = {
        @Tag(name = "Events")
})
@RequestMapping("/api/events")
public interface EventsApi {

    @Operation(summary = "delete event", description = "for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "event not found",
                    content = {
                            @Content()//wernem s pustim kontentom
                    }),
            @ApiResponse(responseCode = "200", description = "deleted event",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @DeleteMapping("/{event-id}")
    ResponseEntity<EventDto> deleteEvent(@Parameter(required = true, description = "event's id", example = "2")//dokumentazia
                       @PathVariable("event-id") Long eventId);//springowskaja annotazia



    @Operation(summary = "update event", description = "for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "user not found",
                    content = {
                            @Content()//wernem s pustim kontentom
                    }),
            @ApiResponse(responseCode = "200", description = "updated user",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @PutMapping("/{event-id}")
    ResponseEntity<EventDto> updateEvent(@Parameter(required = true, description = "event's id", example = "2")
                       @PathVariable("event-id") Long eventId,
                       @RequestBody UpdateEventDto updateEvent);




    @Operation(summary = "get event", description = "for all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "user not found",
                    content = {
                            @Content()//wernem s pustim kontentom
                    }),
            @ApiResponse(responseCode = "200", description = "updated event",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @GetMapping("/{event-id}")
    ResponseEntity<EventDto> getEvent(@Parameter(required = true, description = "event's id", example = "2")
                    @PathVariable("event-id") Long eventId);






    @Operation(summary = "created user events", description = "only for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "users id not exist",
                    content = {
                            @Content()//wernem s pustim kontentom
                    }),
            @ApiResponse(responseCode = "201", description = "added event",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class))
                    })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EventDto> addUserEvent(@Parameter(required= true, description = "event") @RequestBody @Valid NewEventDto newEvent);



}



