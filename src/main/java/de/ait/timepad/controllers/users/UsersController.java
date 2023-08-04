package de.ait.timepad.controllers.users;
import de.ait.timepad.controllers.api.UsersApi;
import de.ait.timepad.dto.articles.ArticlesDto;
import de.ait.timepad.dto.events.EventsDto;
import de.ait.timepad.dto.users.NewUserDto;
import de.ait.timepad.dto.users.UpdateUserDto;
import de.ait.timepad.dto.users.UserDto;
import de.ait.timepad.dto.users.UsersDto;
import de.ait.timepad.services.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class UsersController implements UsersApi {

    private final UsersService usersService;

    @Override
    public ResponseEntity<UserDto> addUser(NewUserDto newUser) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usersService.addUser(newUser));
    }

    @Override
    public ResponseEntity<UsersDto> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(Long userId) {
        return ResponseEntity.ok(usersService.deleteUser(userId));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(Long userId, UpdateUserDto updateUser) {
        return ResponseEntity.ok(usersService.updateUser(userId, updateUser));
    }

    @Override
    public ResponseEntity<UserDto> getUser(Long userId) {
        return ResponseEntity.ok(usersService.getUser(userId));
    }


    @Override
    public ResponseEntity<ArticlesDto> getArticlesOfUser(Long userId) {
        return ResponseEntity.ok(usersService.getArticlesOfUser(userId));
    }

    @Override
    public ResponseEntity<EventsDto> getEventsOfUser(Long userId) {
        return ResponseEntity.ok(usersService.getEventsOfUser(userId));
    }

}
