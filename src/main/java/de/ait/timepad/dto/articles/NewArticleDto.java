package de.ait.timepad.dto.articles;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Добавляемая статья")
public class NewArticleDto {

    @Schema(description = "Текст статьи", example = "Текст о пользователе...")
    @NotNull
    @NotBlank
    private String text;

    @Schema(description = "Идентификатор пользователя", example = "1")
    @NotNull
    private Long aboutUserId;

    @Schema(description = "Дата публикации в формате YYYY-MM-DD", example = "2022-02-02")
    @NotNull
    @NotBlank
    private String publishDate;
}
