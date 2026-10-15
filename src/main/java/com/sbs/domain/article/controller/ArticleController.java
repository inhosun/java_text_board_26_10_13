package com.sbs.domain.article.controller;

import com.sbs.domain.article.dto.Article;
import com.sbs.domain.article.global.base.container.Container;
import com.sbs.domain.article.global.base.rq.Rq;
import com.sbs.domain.article.service.ArticleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArticleController {

    private ArticleService articleService;

    public ArticleController() {

        articleService = Container.articleService;


    }

    public void doWrite() {

        System.out.println("제목 :  ");
        String title = Container.sc.nextLine();

        System.out.println("내용 : ");
        String content = Container.sc.nextLine();

        Article article = articleService.write(title, content);

        System.out.printf("%d번 게시물이 등록 되었습니다 \n",article.getId());
    }

    public void showDetail(Rq rq) {

        int id = rq.getPathVariable();

        if(id == 0) {
            System.out.println("올바를 값을 입력하세요");
            return;
        }
        Article article = articleService.findById(id);


        // 3. 게시물이 존재하지 않는 경우 처리
        if (article == null) {
            System.out.printf("%d번 게시물을 찾을 수 없습니다.\n", id);
            return; // 게시물이 없으므로 여기서 종료
        }

        // 4. 정상 출력
        System.out.printf("==%d번 게시물 상세보기==\n", article.getId());
        System.out.printf("번호 : %d\n", article.getId());
        System.out.printf("제목 : %s\n", article.getTitle());
        System.out.printf("내용 : %s\n", article.getContent());

    }

    public void showList() {

        List<Article> articles = articleService.getArticles();

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


}
