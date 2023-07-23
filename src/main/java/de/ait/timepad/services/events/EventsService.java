package de.ait.timepad.services.events;

import de.ait.timepad.dto.events.EventDto;
import de.ait.timepad.dto.events.EventsDto;
import de.ait.timepad.dto.events.NewEventDto;
import de.ait.timepad.models.Event;

public interface EventsService {
    EventDto addEvent(NewEventDto newEvent);

    EventsDto getAllEvents();
}
