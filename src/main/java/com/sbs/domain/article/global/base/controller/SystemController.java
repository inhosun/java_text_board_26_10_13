package com.sbs.domain.article.global.base.controller;

import com.sbs.domain.article.controller.ArticleController;
import com.sbs.domain.article.dto.Article;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SystemController {

    private ArticleController articleController;

    public SystemController() {
        articleController = new ArticleController();
    }

    public  void run() {

        Scanner sc = new Scanner(System.in);

        System.out.println("== 자바 게시판 시작 ==");

        boolean run = true;

        while(run) {
            System.out.println("명령");
            String cmd = sc.nextLine();
            String[] urlBits = cmd.trim().split("/");

            String urlPathUserType = null;
            String urlPathUserResource = null;
            String urlPathUserAction = null;
            String urlPathVariable = null;

            if(urlBits.length != 0) {
                urlPathUserType = urlBits[1];
                urlPathUserResource = urlBits[2];
                urlPathUserAction = urlBits[3];
            }

            if(urlBits.length > 4) {
                urlPathVariable = urlBits[4];
            }

            switch (urlPathUserType) {
                case  "usr" -> {
                    switch (urlPathUserResource) {
                        case "article" -> {
                            switch (urlPathUserAction) {
                                case "write" -> articleController.doWrite();
                                case "detail" -> articleController.showDetail(urlPathVariable);
                                case "list" -> articleController.showList();
                            }
                        }
                    }
                }
                case "exit" -> {
                    System.out.println("프로그램을 종료 합니다.");
                    System.out.println("== 자바 게시판 종료 ==");
                    run = false;
                }
                default -> {
                    System.out.println("명령어 확인 후 다시 입력해 주세요!");

                }
            }

            System.out.println("입력 받은 명령어 " + cmd);

            /*
            if(cmd.equals("/usr/article/write")) {


            } else if(cmd.startsWith("/usr/article/detail")) {

                String[] urlBits = cmd.trim().split("/");



                if (urlBits.length < 5) {
                    System.out.println("id를 입력하세요");
                    continue;
                }

                int id = Integer.parseInt(urlBits[4]);

                if(articles.size() == 0) {
                    System.out.println("해당 게시물은 존재하지 않습니다");
                    continue;
                }

                Article  findArticle = articles.stream()
                        .filter(s -> s.id == id)
                        .findAny()
                        .orElse(null);

                System.out.printf("==%d번 게시물 상세보기==\n",findArticle.id);
                System.out.printf("번호 : %d\n", findArticle.id);
                System.out.printf("제목 : %s\n", findArticle.title);
                System.out.printf("내용 : %s\n", findArticle.content);

            } else if(cmd.equals("/usr/article/list")) {


                if(articles.isEmpty()) {
                    System.out.println("해당 게시물은 존재하지 않습니다");
                    continue;
                }
                System.out.println("== 게시물 리스트 ==");
                System.out.println("순번  ||  제목  ||   내용");

                articles.stream()
                        .sorted(Comparator.comparingInt((Article s)->s.getId()).reversed())
                        .forEach(s-> System.out.printf("%d   %s  %s \n", s.getId(), s.getTitle(), s.getContent()));
                  */

            /*
            articles.forEach(
                    s-> System.out.printf("%d   %s  %s \n", s.getId(), s.getTitle(), s.getContent())
            );
*/
           /* for(int i = articles.size()-1; i >=0; i-- ) {
                System.out.printf("%d   %s  %s \n",
                        articles.get(i).getId(),
                        articles.get(i).getTitle(),
                        articles.get(i).getContent());
            }

            }
            else if(cmd.equals("exit")) {
                run = false;
            } else {
                System.out.println("명령어 확인 후 다시 입력해 주세요!");
            }

*/
        }



        sc.close();
    }


}
