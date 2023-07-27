package de.ait.timepad.repositories.events.impl;
import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.events.EventsRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EventsRepositoryListImpl implements EventsRepository {
    private static List<Event> events = new ArrayList<>();

    @Override
    public void save(Event event) {
        if(event.getId() == null) {
            event.setId((long) events.size() + 1); // id event - его порядковый номер в списке
            events.add(event);
        } else {
            //TODO: esli bi eto bila BD to nuschno najti ego tam i obnowitj
            //update List nenado, a dlja BD nuschno objasatelno save i tut logiku propisatj dlja obnowlenia w DB
        }
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public Optional<Event> findById(Long id) {
        for(Event event : events) {
            if( event.getId().equals(id)) {
                return Optional.of(event);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(Event event) {
        events.remove(event);
    }

    @Override
    public void clear() {
        events.clear();
    }


}
