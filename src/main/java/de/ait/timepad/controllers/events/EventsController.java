package de.ait.timepad.controllers.events;

import de.ait.timepad.dto.events.EventDto;
import de.ait.timepad.dto.events.EventsDto;
import de.ait.timepad.dto.events.NewEventDto;
import de.ait.timepad.services.events.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventsController {

    private final EventsService eventsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventDto addEvents(@RequestBody NewEventDto newEvent){
        return eventsService.addEvent(newEvent);
    }

    @GetMapping
    public EventsDto getAllEvents(){
        return eventsService.getAllEvents();
    }
}
