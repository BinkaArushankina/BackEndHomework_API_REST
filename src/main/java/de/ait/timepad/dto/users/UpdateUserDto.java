package de.ait.timepad.dto.users;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "data for update")
public class UpdateUserDto {

    @Schema(description = "user's role - MANAGER", example = "USER")
    private String newRole;

    @Schema(description = "user's state - NOT_CONFIRMED, CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
    private String newState;
}
