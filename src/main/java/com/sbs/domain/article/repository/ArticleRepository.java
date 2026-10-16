package com.sbs.domain.article.repository;

import com.sbs.domain.article.dto.Article;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {

    private List<Article> articles;
    private int lastId;

    public ArticleRepository() {
        articles = new ArrayList<>();
        makeArticleTestData(articles);
        lastId = articles.get(articles.size()-1).getId();
    }
    public Article save(String title, String content) {

        Article article = new Article(lastId,title, content);
        System.out.println("생성된 객체 " + article);
        articles.add(article);
        return article;

    }

    public List<Article> findByAll() {
        return articles.stream()
                .sorted(Comparator.comparing( (Article article)->article.getId()).reversed())
                .toList();
    }

    public Article findById(int id) {
            return articles.stream()
                    .filter(s -> s.getId() == id)
                    .findFirst()
                    .orElse(null);

    }
    private  void makeArticleTestData(List<Article> article) {
        IntStream.rangeClosed(1,30)
                .forEach(i-> articles.add(new Article(i,"제목"+i, "내용"+i)));

    }

    public void modify(int id, String title, String content) {
        Article article = findById(id);
        if(article == null) return;
        article.setTitle(title);
        article.setContent(content);
    }

    public void remove(int id) {
        Article article = findById(id);
        if(article == null) return;
       // articles.removeIf(s-> s.getId() == id);
        articles.remove(article);
    }
}
