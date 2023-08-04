package de.ait.timepad.dto.users;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "data for update")
public class UpdateUserDto {

    @Schema(description = "user's role - MANAGER", example = "USER")
    @NotNull
    @NotBlank
    private String newRole;

    @Schema(description = "user's state - NOT_CONFIRMED, CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
    @NotNull
    @NotBlank
    private String newState;
}
