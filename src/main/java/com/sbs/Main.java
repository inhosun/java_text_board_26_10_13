
package com.sbs;

import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("== 자바 게시판 시작 ==");
    while(true) {
        System.out.println("명령");
        String cmd = sc.nextLine();

        System.out.println("입력 받은 명령어 " + cmd);

        if(cmd.equals("exit")) {
            System.out.println("프로그램 종료");
            break;
        }

    }
    System.out.println("== 자바 게시판 종료 ==");
    sc.close();
    }
}