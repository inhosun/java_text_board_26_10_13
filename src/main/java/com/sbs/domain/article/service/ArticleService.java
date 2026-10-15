package com.sbs.domain.article.service;

import com.sbs.domain.article.dto.Article;
import com.sbs.domain.article.global.base.container.Container;
import com.sbs.domain.article.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleService {


    private ArticleRepository articleRepository;

    public ArticleService() {

        articleRepository = Container.articleRepository;

    }



    public Article write(String title, String content) {
        return articleRepository.save(title, content);
    }

    public List<Article> getArticles() {
        return articleRepository.findByAll();

    }

    public Article findById(int id) {
        return articleRepository.findById(id);

    }
}
