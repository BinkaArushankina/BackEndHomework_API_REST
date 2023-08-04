package de.ait.timepad.dto.users;

import de.ait.timepad.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Информация о пользователе в статье")

public class UserInArticleDto {

    @Schema(description = "Идентификатор пользователя", example = "1")
    @NotNull
    private Long id;

    @Schema(description = "Email пользователя", example = "user@mail.com")
    @NotNull
    @NotBlank
    @Email
    private String email;

    public static UserInArticleDto from(User user) {
        return UserInArticleDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
