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

    static {
        lastId = 0;
    }

    public Article(String title, String content) {
        this(++lastId, title, content);
    }
    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    @Override
    public String toString() {
       // return "{id : %d , title : %s , content : %s}".formatted(id, title, content);
        return String.format("{id : %d , title : %s , content : %s}", id, title, content);
    }


}
