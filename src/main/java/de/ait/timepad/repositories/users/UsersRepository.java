package de.ait.timepad.repositories.users;

import de.ait.timepad.models.User;
import de.ait.timepad.repositories.CrudRepository;


public interface UsersRepository extends CrudRepository<User> {


    // TODO: delete the method as soon as we connect the databases
    void clear();
}
