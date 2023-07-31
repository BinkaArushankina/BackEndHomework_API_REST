package de.ait.timepad.controllers.articles;

import de.ait.timepad.controllers.api.ArticlesApi;
import de.ait.timepad.dto.articles.ArticleDto;
import de.ait.timepad.dto.articles.ArticlesDto;
import de.ait.timepad.dto.articles.NewArticleDto;
import de.ait.timepad.services.articles.ArticlesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticlesController implements ArticlesApi {

    private final ArticlesService articlesService;

    @Override
    public ResponseEntity<ArticleDto> addArticle(NewArticleDto newArticle) {
         return ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(articlesService.addArticle(newArticle));
    }

    @Override
    public ArticlesDto getArticles(Integer year, Integer month, Integer day) {
        return articlesService.getArticles(year, month, day);
    }
}
