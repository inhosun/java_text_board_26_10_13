package com.sbs.domain.article.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Article {

    private static int lastId;
    private int id;

    private String title;
    private String content;
    private int memberId;

    static {
        lastId = 0;
    }

    public Article(String title, String content, int memberId) {
        this(++lastId, title, content,memberId);
    }
    public Article(int id, String title, String content, int memberId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }


    @Override
    public String toString() {
       // return "{id : %d , title : %s , content : %s}".formatted(id, title, content);
        return String.format("{id : %d , title : %s , content : %s , writerId : %d}", id, title, content, memberId);
    }


    public Article edit(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
        return article;
    }
}
