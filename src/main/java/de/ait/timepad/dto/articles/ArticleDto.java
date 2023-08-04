package de.ait.timepad.dto.articles;

import de.ait.timepad.dto.users.UserInArticleDto;
import de.ait.timepad.models.Article;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Статья о каком-либо пользователе")

public class ArticleDto {

    @Schema(description = "Идентификатор статьи", example = "1")
    @NotNull
    private Long id;

    @Schema(description = "Текст статьи", example = "Текст о каком-либо пользователе...")
    @NotNull
    @NotBlank
    private String text;

    @Schema(description = "Пользователь, которому посвящена статья")
    private UserInArticleDto about;

    @Schema(description = "Дата публикации в формате YYYY-MM-DD", example = "2022-02-02")
    @NotNull
    @NotBlank
    private String publishDate;

    public static ArticleDto from(Article article) {
        ArticleDto result = ArticleDto.builder()
                .id(article.getId())
                .text(article.getText())
                .build();


        if (article.getPublishDate() != null) {
            result.setPublishDate(article.getPublishDate().toString());
        }

        return result;
    }

    public static List<ArticleDto> from(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }

}
