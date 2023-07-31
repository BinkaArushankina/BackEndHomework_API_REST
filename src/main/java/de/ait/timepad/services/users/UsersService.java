package de.ait.timepad.services.users;

import de.ait.timepad.dto.articles.ArticlesDto;
import de.ait.timepad.dto.events.EventsDto;
import de.ait.timepad.dto.users.NewUserDto;
import de.ait.timepad.dto.users.UpdateUserDto;
import de.ait.timepad.dto.users.UserDto;
import de.ait.timepad.dto.users.UsersDto;

public interface UsersService {
    UserDto addUser(NewUserDto newUser);

    UsersDto getAllUsers();

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long userId, UpdateUserDto updateUser);

    UserDto getUser(Long userId);

    ArticlesDto getArticlesOfUser(Long userId);

    EventsDto getEventsOfUser(Long userId);
}
