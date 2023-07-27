package de.ait.timepad.repositories.events;
import de.ait.timepad.models.Event;
import java.util.List;
import java.util.Optional;

public interface EventsRepository {
    void save(Event event);

    List<Event> findAll();

    Optional<Event> findById(Long id);


    void delete(Event event);


    // TODO: delete the method as soon as we connect the databases
    void clear();

}
