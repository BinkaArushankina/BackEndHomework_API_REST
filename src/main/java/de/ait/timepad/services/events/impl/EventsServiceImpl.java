package de.ait.timepad.services.events.impl;
import de.ait.timepad.dto.events.EventDto;
import de.ait.timepad.dto.events.EventsDto;
import de.ait.timepad.dto.events.NewEventDto;
import de.ait.timepad.dto.events.UpdateEventDto;
import de.ait.timepad.exceptions.ForbiddenOperationException;
import de.ait.timepad.exceptions.IncorrectUserIdException;
import de.ait.timepad.exceptions.NotFoundException;
import de.ait.timepad.models.Event;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.events.EventsRepository;
import de.ait.timepad.repositories.users.UsersRepository;
import de.ait.timepad.services.events.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static de.ait.timepad.dto.events.EventDto.from;

@Service
@RequiredArgsConstructor
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;
    private final UsersRepository usersRepository;

    @Override
    public EventDto addEvent(NewEventDto newEvent) {

        Event event = Event.builder()
                .name(newEvent.getName())
                .eventType(Event.EventType.PARTY)
                .state(Event.State.CONFIRMED)
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

    @Override
    public EventDto deleteEvent(Long eventId) {
        //Optional<User> user = usersRepository.findById(userId);//snatschala nachodim polsowatela a potom udalaju
        //if (user.isEmpty()) {
        //    throw new NotFoundException("User with id <" + userId + "> not found");
        //}
        //usersRepository.delete(user.get());//udalaem naschedschego

        Event event = getEventOrThrow(eventId);

        eventsRepository.delete(event);//udalaem naschedschego

        return EventDto.from(event);
    }

    @Override
    public EventDto updateEvent(Long eventId, UpdateEventDto updateEvent) {

        Event event = getEventOrThrow(eventId);//naschli

        if(updateEvent.getNewEventType().equals("CONCERT")) {//nuschno sapretitj nasnatchatj kogo to adminom
            throw new ForbiddenOperationException("Cannot rename to concert");
        }

        event.setState(Event.State.valueOf(updateEvent.getNewState()));//obnowlaem pola emu
        event.setEventType(Event.EventType.valueOf(updateEvent.getNewEventType()));

        eventsRepository.save(event);//wmesto update ispolsuem save

        return EventDto.from(event);//woswr obnowlennij event
    }

    @Override
    public EventDto getEvent(Long eventId) {
        return EventDto.from(getEventOrThrow(eventId));
    }

    @Override
    public EventDto addUserEvent(NewEventDto newEvent) {
        User user = usersRepository.findById(newEvent.getAboutUserId())
                .orElseThrow(() ->
                        new IncorrectUserIdException("Id < " + newEvent.getAboutUserId() + " > is not correct"));
        Event event = Event.builder()
                .name(newEvent.getName())
                .eventType(Event.EventType.PARTY)
                .about(user)
                .publishDate(LocalDate.parse(newEvent.getPublishDate()))
                .build();

        eventsRepository.save(event);//objasatelno sochranaem etot event

        return from(event);//woswraschaem EventDto
    }



    private Event getEventOrThrow(Long eventId) {
        return  eventsRepository.findById(eventId).orElseThrow(
                () -> new NotFoundException("Event with id <" + eventId + "> not found"));

    }
}
