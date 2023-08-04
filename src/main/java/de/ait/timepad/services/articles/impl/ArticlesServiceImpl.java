package de.ait.timepad.services.articles.impl;

import de.ait.timepad.dto.articles.ArticleDto;
import de.ait.timepad.dto.articles.ArticlesDto;
import de.ait.timepad.dto.articles.NewArticleDto;
import de.ait.timepad.exceptions.IncorrectUserIdException;
import de.ait.timepad.models.Article;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.articles.ArticlesRepository;
import de.ait.timepad.repositories.users.UsersRepository;
import de.ait.timepad.services.articles.ArticlesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static de.ait.timepad.dto.articles.ArticleDto.from;

@RequiredArgsConstructor
@Service
public class ArticlesServiceImpl implements ArticlesService {

    private final UsersRepository usersRepository;

    private final ArticlesRepository articlesRepository;

    @Override
    public ArticleDto addArticle(NewArticleDto newArticle) {
        User user = usersRepository.findById(newArticle.getAboutUserId())
                .orElseThrow(() ->
                        new IncorrectUserIdException("Id <" + newArticle.getAboutUserId() + "> is not correct"));

        Article article = Article.builder()
                .text(newArticle.getText())
                .about(user)
                .publishDate(LocalDate.parse(newArticle.getPublishDate()))
                .build();

        articlesRepository.save(article);

        return from(article);
    }



}
