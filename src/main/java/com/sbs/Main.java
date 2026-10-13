
package com.sbs;

import com.sbs.domain.article.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("== 자바 게시판 시작 ==");
    boolean run = true;

    List<Article> articleList = new ArrayList<>();

    int lastId = 0;

    while(run) {
        System.out.println("명령");
        String cmd = sc.nextLine();

        System.out.println("입력 받은 명령어 " + cmd);

        if(cmd.equals("/usr/article/write")) {
            System.out.println("제목 :  ");
            String title = sc.nextLine();

            System.out.println("내용 : ");
            String content = sc.nextLine();

            int id = ++lastId;

            Article article = new Article();
            article.id = id;
            article.title = title;
            article.content = content;

            System.out.println("생성된 객체 " + article);
            articleList.add(article);
            System.out.printf("%d번 게시물이 등록 되었습니다 \n",id);

        } else if(cmd.startsWith("/usr/article/detail")) {

            String[] urlBits = cmd.trim().split("/");



            if (urlBits.length < 5) {
                System.out.println("id를 입력하세요");
                continue;
            }

            int id = Integer.parseInt(urlBits[4]);

            if(articleList.size() == 0) {
                System.out.println("해당 게시물은 존재하지 않습니다");
                continue;
            }

            Article  findArticle = articleList.stream()
                    .filter(s -> s.id == id)
                    .findAny()
                    .orElse(null);

            System.out.printf("==%d번 게시물 상세보기==\n",findArticle.id);
            System.out.printf("번호 : %d\n", findArticle.id);
            System.out.printf("제목 : %s\n", findArticle.title);
            System.out.printf("내용 : %s\n", findArticle.content);

        } else if(cmd.equals("exit")) {
            run = false;
        } else {
            System.out.println("명령어 확인 후 다시 입력해 주세요!");
        }


    }
    System.out.println("== 자바 게시판 종료 ==");
    sc.close();
    }
}