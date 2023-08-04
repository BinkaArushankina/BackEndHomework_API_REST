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
    public ResponseEntity<EventDto> deleteEvent(Long eventId) {
        return ResponseEntity.ok(eventsService.deleteEvent(eventId));
    }

    @Override
    public ResponseEntity<EventDto> updateEvent(Long eventId, UpdateEventDto updateEvent) {
        return ResponseEntity.ok(eventsService.updateEvent(eventId, updateEvent));
    }

    @Override
    public ResponseEntity<EventDto> getEvent(Long eventId) {
        return ResponseEntity.ok(eventsService.getEvent(eventId));
    }


    @Override
    public ResponseEntity<EventDto> addUserEvent(NewEventDto newEvent) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(eventsService.addUserEvent(newEvent));
    }


}
