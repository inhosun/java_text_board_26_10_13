package com.sbs.domain.article;

public class Article {
    public int id;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String title;
    public String content;
}
