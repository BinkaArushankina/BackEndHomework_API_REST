package de.ait.timepad.services.users.impl;

import de.ait.timepad.dto.users.NewUserDto;
import de.ait.timepad.dto.users.UpdateUserDto;
import de.ait.timepad.dto.users.UserDto;
import de.ait.timepad.dto.users.UsersDto;
import de.ait.timepad.exceptions.ForbiddenOperationException;
import de.ait.timepad.exceptions.NotFoundException;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.users.UsersRepository;
import de.ait.timepad.services.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static de.ait.timepad.dto.users.UserDto.from;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public UserDto addUser(NewUserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .role(User.Role.USER)
                .state(User.State.NOT_CONFIRMED).build();

        usersRepository.save(user);

        return from(user);
    }

    @Override
    public UsersDto getAllUsers() {
//        List<User> users = usersRepository.findAll();
//
//        List<UserDto> dtos = new ArrayList<>();
//
//        for (User user : users) {
//            UserDto userDto = from(user);
//            dtos.add(userDto);
//        }
        List<User> users = usersRepository.findAll();
        return UsersDto.builder()
                .users(from(users))
                .count(users.size())
                .build();
    }


    @Override
    public UserDto deleteUser(Long userId) {
        //Optional<User> user = usersRepository.findById(userId);//snatschala nachodim polsowatela a potom udalaju
        //if (user.isEmpty()) {
        //    throw new NotFoundException("User with id <" + userId + "> not found");
        //}
        //usersRepository.delete(user.get());//udalaem naschedschego

        User user = getUserOrThrow(userId);

        usersRepository.delete(user);//udalaem naschedschego

        return from(user);
    }


    @Override
    public UserDto updateUser(Long userId, UpdateUserDto updateUser) {

        User user = getUserOrThrow(userId);//naschli usera

        if(updateUser.getNewRole().equals("ADMIN")) {//nuschno sapretitj nasnatchatj kogo to adminom
            throw new ForbiddenOperationException("Cannot make an administrator");
        }

        user.setState(User.State.valueOf(updateUser.getNewState()));//obnowlaem pola emu
        user.setRole(User.Role.valueOf(updateUser.getNewRole()));

        usersRepository.save(user);//wmesto update ispolsuem save

        return from(user);//woswr obnowlennogo polsowatela
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }

    private User getUserOrThrow(Long userId) {
        return  usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User with id <" + userId + "> not found"));//snatschala nachodim polsowatela a potom udalaju

    }

}
