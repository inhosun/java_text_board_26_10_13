package com.sbs.domain.article.dto;

public class Article {
    public int id;

    public String title;

    public String content;

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
       // return "{id : %d , title : %s , content : %s}".formatted(id, title, content);
        return String.format("{id : %d , title : %s , content : %s}", id, title, content);
    }


}
