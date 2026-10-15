package com.sbs.domain.article.global.base.controller;

import com.sbs.domain.article.controller.ArticleController;
import com.sbs.domain.article.dto.Article;
import com.sbs.domain.article.global.base.container.Container;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SystemController {

    private ArticleController articleController;

    public SystemController() {
        articleController = Container.articleController;
    }

    public  void run() {



        System.out.println("== 자바 게시판 시작 ==");

        boolean run = true;

        while(run) {
            System.out.println("명령");
            String cmd = Container.sc.nextLine();

            if(cmd.trim().isEmpty()) {
                System.out.println("명령어를 입력하세요");
                continue;
            }
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

            if(urlBits.length < 4) {
                System.out.println("올바를 URL 형식이 아닙니다.");
                continue;
            }
            if(urlBits.length > 4) {
                urlPathVariable = urlBits[4];
            }

            if(!urlPathUserType.startsWith("usr")) {
                System.out.println("명령어를 잘 못 입력하였습니다.");
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


        }



        Container.sc.close();
    }


}
