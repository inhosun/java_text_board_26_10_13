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

    public void modify(int id, String title, String content) {
         articleRepository.modify(id, title, content);
         System.out.printf("%d 게시물을 수정하였습니다 \n/u", id);
    }

    public void remove(int id) {
        articleRepository.remove(id);
        System.out.printf("%d 게시물을 삭하였습니다 \n/u", id);
    }
}
