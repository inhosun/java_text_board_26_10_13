package com.sbs.domain.article.dto;

public class Article {

    private static int lastId;
    private int id;

    private String title;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    public Article(String title, String content) {
        this(++lastId, title, content);
    }
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
