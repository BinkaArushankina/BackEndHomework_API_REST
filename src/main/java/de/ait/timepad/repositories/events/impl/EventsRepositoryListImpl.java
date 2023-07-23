package de.ait.timepad.repositories.events.impl;

import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.events.EventsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EventsRepositoryListImpl implements EventsRepository {
    private static List<Event> events = new ArrayList<>();

    @Override
    public void save(Event event) {
        events.add(event);
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public void clear() {
        events.clear();
    }


}
