package de.ait.timepad.repositories.events;
import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.CrudRepository;

import java.util.List;

public interface EventsRepository extends CrudRepository<Event> {

    // TODO: delete the method as soon as we connect the databases
    void clear();

    List<Event> findAllByDate(Integer year, Integer month, Integer day );

}
