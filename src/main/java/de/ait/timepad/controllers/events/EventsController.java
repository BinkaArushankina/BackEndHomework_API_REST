package de.ait.timepad.controllers.events;
import de.ait.timepad.controllers.api.EventsApi;
import de.ait.timepad.dto.events.EventDto;
import de.ait.timepad.dto.events.EventsDto;
import de.ait.timepad.dto.events.NewEventDto;
import de.ait.timepad.dto.events.UpdateEventDto;
import de.ait.timepad.dto.users.NewUserDto;
import de.ait.timepad.dto.users.UpdateUserDto;
import de.ait.timepad.dto.users.UserDto;
import de.ait.timepad.dto.users.UsersDto;
import de.ait.timepad.services.events.EventsService;
import de.ait.timepad.services.users.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class EventsController implements EventsApi {

    private final EventsService eventsService;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        return eventsService.addEvent(newEvent);
    }

    @Override
    public EventsDto getAllEvents() {
        return eventsService.getAllEvents();
    }

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

}
