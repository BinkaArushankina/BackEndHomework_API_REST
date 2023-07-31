package de.ait.timepad.dto.users;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Schema(description = "Data for added new User")
@Data
public class NewUserDto {

    @Schema(description = "User's email", example = "example@mail.com")
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Schema(description = "User's password", example = "qwerty007")
    @NotBlank
    @Size(min = 7, max = 20)
    private String password;
}
