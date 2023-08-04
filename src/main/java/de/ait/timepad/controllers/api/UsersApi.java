package de.ait.timepad.controllers.api;
import de.ait.timepad.dto.articles.ArticlesDto;
import de.ait.timepad.dto.events.EventsDto;
import de.ait.timepad.dto.users.NewUserDto;
import de.ait.timepad.dto.users.UpdateUserDto;
import de.ait.timepad.dto.users.UserDto;
import de.ait.timepad.dto.users.UsersDto;
import de.ait.timepad.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tags(value = {
        @Tag(name = "Users")
})
@RequestMapping("/api/users")
public interface UsersApi {

    @Operation(summary = "created user", description = "only for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created user",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }),
            @ApiResponse(responseCode = "400", description = "validation error",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
                    })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<UserDto> addUser(@Parameter(required= true, description = "user") @RequestBody @Valid NewUserDto newUser);



    @Operation(summary = "delete user", description = "for admin")
    @ApiResponses(value = {
         @ApiResponse(responseCode = "404", description = "user not found",
                 content = {
                 @Content()//wernem s pustim kontentom
                 }),
         @ApiResponse(responseCode = "200", description = "deleted user",
                 content = {
                 @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
         })
    })
    @DeleteMapping("/{user-id}")
    ResponseEntity<UserDto> deleteUser(@Parameter(required = true, description = "user's id", example = "2")//dokumentazia
                       @PathVariable("user-id") Long userId);//springowskaja annotazia



    @Operation(summary = "update user", description = "for admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "user not found",
                    content = {
                            @Content()//wernem s pustim kontentom
                    }),
            @ApiResponse(responseCode = "403", description = "Cannot make an administrator",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "updated user",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @PutMapping("/{user-id}")
    ResponseEntity<UserDto> updateUser(@Parameter(required = true, description = "user's id", example = "2")//dokumentazia
                       @PathVariable("user-id") Long userId,//springowskaja annotazia
                       @RequestBody UpdateUserDto updateUser);




    @Operation(summary = "get user", description = "for all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "user not found",
                    content = {
                            @Content()//wernem s pustim kontentom
                    }),
            @ApiResponse(responseCode = "200", description = "updated user",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @GetMapping("/{user-id}")
    ResponseEntity<UserDto> getUser(@Parameter(required = true, description = "user's id", example = "2")//dokumentazia
                       @PathVariable("user-id") Long userId);//springowskaja annotazia



    @Operation(summary = "Получение всех статей пользователя", description = "Доступно всем")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Статьи пользователя ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ArticlesDto.class))
                    })
    })
    @GetMapping("/{user-id}/articles")
    ResponseEntity<ArticlesDto> getArticlesOfUser(@Parameter(required = true, description = "Идентификатор пользователя", example = "2")
                                  @PathVariable("user-id") Long userId);




    @Operation(summary = "Получение всех event пользователя", description = "Доступно всем")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Статьи пользователя ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EventsDto.class))
                    })
    })
    @GetMapping("/{user-id}/events")
    ResponseEntity<EventsDto> getEventsOfUser(@Parameter(required = true, description = "Идентификатор пользователя", example = "2")
                                  @PathVariable("user-id") Long userId);



    @Operation(summary = "get all user", description = "for all")
    @GetMapping
    ResponseEntity<UsersDto> getAllUsers();
}
