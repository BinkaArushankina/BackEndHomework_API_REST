package de.ait.timepad.services.articles;

import de.ait.timepad.dto.articles.ArticleDto;
import de.ait.timepad.dto.articles.ArticlesDto;
import de.ait.timepad.dto.articles.NewArticleDto;

public interface ArticlesService {

    ArticleDto addArticle(NewArticleDto newArticle);

    ArticlesDto getArticles(Integer year, Integer month, Integer day);

}
