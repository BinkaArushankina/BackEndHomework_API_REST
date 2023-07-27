package de.ait.timepad.repositories.users.impl;

import de.ait.timepad.models.User;
import de.ait.timepad.repositories.users.UsersRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryListImpl implements UsersRepository {
    private static List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        if(user.getId() == null) {
            user.setId((long) users.size() + 1); // id пользователя - его порядковый номер в списке
            users.add(user);
        } else {
            //TODO: esli bi eto bila BD to nuschno najti ego tam i obnowitj
            //update List nenado, a dlja BD nuschno objasatelno save i tut logiku propisatj dlja obnowlenia w DB
        }
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> findById(Long id) {
        for(User user : users) {
            if( user.getId().equals(id)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public void clear() {
        users.clear();
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}
