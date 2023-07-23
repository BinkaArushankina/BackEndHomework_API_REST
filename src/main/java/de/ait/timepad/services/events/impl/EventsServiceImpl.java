package de.ait.timepad.services.events.impl;

import de.ait.timepad.dto.events.EventDto;
import de.ait.timepad.dto.events.EventsDto;
import de.ait.timepad.dto.events.NewEventDto;
import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.events.EventsRepository;
import de.ait.timepad.services.events.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static de.ait.timepad.dto.events.EventDto.from;

@Service
@RequiredArgsConstructor
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;
    @Override
    public EventDto addEvent(NewEventDto newEvent) {

        Event event = Event.builder()
                .name(newEvent.getName())
                .eventType(Event.EventType.NOT_FOUND)
                .build();

        eventsRepository.save(event);
        return from(event);
    }

    @Override
    public EventsDto getAllEvents() {
        //List<Event> events = eventsRepository.findAll();

        //List<EventDto> dtos = new ArrayList<>();

        //for(Event event : events) {
        //    EventDto eventDto = from(event);
        //    dtos.add(eventDto);
        //}

        List<Event> events = eventsRepository.findAll();

        return EventsDto.builder()
                .events(from(events))
                .count(events.size())
                .build();
    }
}
