package de.ait.timepad.dto.users;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "user's List")
public class UsersDto {

    @Schema(description = "system's user")
    private List<UserDto> users;

    @Schema(description = "total numbers of users", example = "1")
    private Integer count;
}
