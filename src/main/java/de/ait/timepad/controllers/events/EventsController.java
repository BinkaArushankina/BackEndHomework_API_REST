package de.ait.timepad.controllers.events;
import de.ait.timepad.controllers.api.EventsApi;
import de.ait.timepad.dto.events.EventDto;
import de.ait.timepad.dto.events.EventsDto;
import de.ait.timepad.dto.events.NewEventDto;
import de.ait.timepad.dto.events.UpdateEventDto;
import de.ait.timepad.services.events.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EventsController implements EventsApi {

    private final EventsService eventsService;


    @Override
    public EventDto deleteEvent(Long eventId) {
        return eventsService.deleteEvent(eventId);
    }

    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {
        return eventsService.updateEvent(eventId, updateEvent);
    }

    @Override
    public EventDto getEvent(Long eventId) {
        return eventsService.getEvent(eventId);
    }




    @Override
    public ResponseEntity<EventDto> addUserEvent(NewEventDto newEvent) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(eventsService.addUserEvent(newEvent));
    }

    @Override
    public EventsDto getEvents(Integer year, Integer month, Integer day) {
        return eventsService.getEvents(year,month,day);
    }

}
