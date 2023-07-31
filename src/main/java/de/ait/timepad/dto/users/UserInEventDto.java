package de.ait.timepad.dto.users;

import de.ait.timepad.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "users info at the event")
public class UserInEventDto {

    @Schema(description = "users id", example = "1")
    private Long id;

    @Schema(description = "users email", example = "user@mail.com")
    private String email;

    public static UserInEventDto from (User user) {
        return UserInEventDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
