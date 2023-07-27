package de.ait.timepad.dto.users;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Schema(description = "Data for added new User")
@Data
public class NewUserDto {
    @Schema(description = "User's email", example = "example@mail.com")
    private String email;
    @Schema(description = "User's password", example = "qwerty007")
    private String password;
}
