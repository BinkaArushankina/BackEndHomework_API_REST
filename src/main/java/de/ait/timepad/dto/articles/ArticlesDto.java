package de.ait.timepad.dto.articles;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Статьи пользователя")

public class ArticlesDto {

    @Schema(description = "Список статей")
    private List<ArticleDto> articles;

    @Schema(description = "Количество статей пользователя", example = "2")
    private Integer count;
}
