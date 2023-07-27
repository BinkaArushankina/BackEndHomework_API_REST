package de.ait.timepad.repositories.users;

import de.ait.timepad.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {

    void save(User user);

    List<User> findAll();


    Optional<User> findById(Long id);


    void delete(User user);


    // TODO: delete the method as soon as we connect the databases
    void clear();
}
