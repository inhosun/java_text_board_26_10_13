package com.sbs.domain.article.global.base.controller;

import com.sbs.domain.article.controller.ArticleController;
import com.sbs.domain.article.dto.Article;
import com.sbs.domain.article.global.base.container.Container;
import com.sbs.domain.article.global.base.intercepter.Intercepter;
import com.sbs.domain.article.global.base.intercepter.NeedLogOutIntercepter;
import com.sbs.domain.article.global.base.intercepter.NeedLoginIntercepter;
import com.sbs.domain.article.global.base.rq.Rq;
import com.sbs.domain.member.controller.MemberController;
import com.sbs.domain.member.member.dto.Member;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SystemController {

    private ArticleController articleController;

    private MemberController memberController;


    public SystemController() {
    }

    public  void run() {


        Rq rq = new Rq();
        System.out.println("== 자바 게시판 시작 ==");

        boolean run = true;

        while(run) {

            String promptName = "명령";
            if(rq.isLogined()) {
                Member member = rq.getLoginedMember();
                promptName = member.getUsername();
            }
            System.out.printf("%s) ",promptName);
            String cmd = Container.sc.nextLine().trim();

            rq.setCommand(cmd);
            rq.getActionPath();

           // System.out.println(runIntercepter(rq));
            if(!runIntercepter(rq)) continue;

            if(rq.getUrl().trim().isEmpty()) {
                System.out.println("명령어를 입력하세요");
                continue;
            }
            if(!rq.getUrlPathUserType().startsWith("usr")) {
                System.out.println("명령어를 잘 못 입력하였습니다.");
                continue;
            }
            
            BaseController baseController = getControllerByRequestUrl(rq);

            if(baseController != null) {
                baseController.doAction(rq);
            }

            if(cmd.trim().equals("exit")) {
                System.out.println("프로그램 종료 합니다");
                System.out.println("자바 게시판 종료");
                break;
            } else {
                System.out.println("명령어를 입력하세요");
            }
            System.out.println("입력 받은 명령어 " + cmd);


        }



        Container.sc.close();
    }

    private BaseController getControllerByRequestUrl(Rq rq) {
        switch (rq.getUrlPathUserType()) {
            case  "usr" -> {
                switch (rq.getUrlPathControllerName()) {
                    case "article" -> {
                       return Container.articleController;
                    }
                    case "member" -> {
                        return Container.memberController;
                    }


                }
            }

        }
        return null;
    }

    public boolean runIntercepter(Rq rq) {
        List<Intercepter> list = new ArrayList<>();

        list.add(Container.needLoginIntercepter);
        list.add(Container.needLogOutIntercepter);

        for(Intercepter intercepter : list) {
            if(!intercepter.run(rq))
                return false;
        }
        return true;

    }

}
