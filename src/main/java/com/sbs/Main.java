
package com.sbs;

import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("== 자바 게시판 시작 ==");
    boolean run = true;

    int lastId = 0;

    while(run) {
        System.out.println("명령");
        String cmd = sc.nextLine();

        System.out.println("입력 받은 명령어 " + cmd);


        switch (cmd) {
            case "/usr/article/write" -> {
                System.out.println("제목 :  ");
                String title = sc.nextLine();

                System.out.println("내용 : ");
                String content = sc.nextLine();

                int id = ++lastId;
                System.out.printf("%d번 게시물이 등록 되었습니다 \n",id);


            }
            case "exit" -> {
                run = false ;
            }
            default -> {
                System.out.println("명령어 확인 후 다시 입력해 주세요!");

            }
        }


    }
    System.out.println("== 자바 게시판 종료 ==");
    sc.close();
    }
}