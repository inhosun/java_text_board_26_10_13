package com.sbs.domain.article.controller;

import com.sbs.domain.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArticleController {

    Scanner sc;
    List<Article> articles;
    int lastId;

    public ArticleController() {
        articles = new ArrayList<>();
        sc = new Scanner(System.in);
        makeArticleTestData(articles);
        lastId = articles.get(articles.size() - 1).getId();
    }

    public void doWrite() {
        System.out.println("제목 :  ");
        String title = sc.nextLine();

        System.out.println("내용 : ");
        String content = sc.nextLine();

        int id = ++lastId;

        Article article = new Article(id, title, content);

        System.out.println("생성된 객체 " + article);
        articles.add(article);
        System.out.printf("%d번 게시물이 등록 되었습니다 \n",id);
    }

    public void showDetail(String id) {
       if(id == null || id.equals("")) {
           System.out.println("id를 입력하세요");
           return;
       }
       int articleId = Integer.parseInt(id);
       Article  findArticle = articles.stream()
                .filter(s -> s.getId() == articleId)
                .findAny()
                .orElse(null);

        System.out.printf("==%d번 게시물 상세보기==\n",findArticle.id);
        System.out.printf("번호 : %d\n", findArticle.id);
        System.out.printf("제목 : %s\n", findArticle.title);
        System.out.printf("내용 : %s\n", findArticle.content);
    }

    public void showList() {

        if(articles.isEmpty()) {
            System.out.println("해당 게시물이 존재하지 않습니다");
            return;
        }
        System.out.println("== 게시물 리스트 ==");
        System.out.println("순번  ||  제목  ||   내용");
        articles.stream()
                .forEach(article->
                        System.out.printf("%d   %s  %s\n", article.getId(),
                                article.getTitle(), article.getContent()));
    }

    private  void makeArticleTestData(List<Article> article) {
        IntStream.rangeClosed(1,30)
                .forEach(i-> articles.add(new Article(i,"제목"+i, "내용"+i)));
        /*article.add(new Article(1, "제목1", "내용1"));
        article.add(new Article(2, "제목2", "내용2"));
        article.add(new Article(3, "제목3", "내용3"));
        article.add(new Article(4, "제목4", "내용4"));
        article.add(new Article(5, "제목5", "내용5"));
        */

    }
}
