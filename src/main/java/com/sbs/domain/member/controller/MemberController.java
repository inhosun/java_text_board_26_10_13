package com.sbs.domain.member.controller;

import com.sbs.domain.article.global.base.container.Container;
import com.sbs.domain.article.global.base.controller.BaseController;
import com.sbs.domain.article.global.base.rq.Rq;
import com.sbs.domain.member.member.dto.Member;
import com.sbs.domain.member.service.MemberService;

import java.util.ArrayList;
import java.util.List;

public class MemberController implements BaseController {

    private MemberService memberService;

    public MemberController() {

        this.memberService = Container.memberService;
    }

    @Override
    public void doAction(Rq rq) {
        switch(rq.getUrlPathUserAction()) {
            case "join" -> {
                doJoin(rq);
            }
            case "login" -> {
                doLogin(rq);
            }
            case "logout" -> {
                doLogout(rq);
            }


        }
    }

    private void doLogout(Rq rq) {
        if(rq.isLogout()) {
            System.out.println("이미 로그아웃 되어 있습니다.");
            return;
        }
        rq.removeAttr("loginedMember");
        System.out.println("로그아웃 되었습니다");
    }

    private void doLogin(Rq rq) {

        if(rq.isLogined()) {
            System.out.println("이미 로그인 되어 있습니다!");
            return;
        }
        String username;
        String password;
        Member member;

        int tryMaxCount = 5;
        int tryCount = 0;
        System.out.println("===== 로그인 =====");
        while(true) {

            System.out.println("아이디 :");
            username = Container.sc.nextLine();

            if (username.isEmpty()) {
                System.out.println("아이디를 입력하세요");
                continue;
            }

            member = memberService.findByUserName(username);
            if (member == null) {
                System.out.println("존재하지 않는 사용자 입니다");
                continue;
            }
            break;
        }

        while(true) {

            if(tryCount == tryMaxCount) {
                System.out.println("비밀번호를 확인후 다시 시도하세요");
                break;
            }
            System.out.println("비밀번호 :");
            password = Container.sc.nextLine();

            if(password.isEmpty()) {
                System.out.println("비밀번호를  입력하세요");
                continue;
            }
            if(!password.equals(member.getPassword())) {
                tryCount++;
                System.out.printf("비밀번호가 틀렸습니다 시도횟수(%d/%d) \n", tryCount, tryMaxCount);
            }
            rq.setAttr("loginedMember", member);
            System.out.printf("%s님 로그인 되었습니다", member.getName());
            break;
        }

    }

    private void doJoin(Rq rq) {

        if(rq.isLogined()) {
            System.out.println("이미 로그인 되어 있습니다!");
            return;
        }

        String username;
        String password;
        String passwordConfirm;
        String name;

        System.out.println("=== 회원 가입 ===");
        while(true) {

            System.out.println("아이디 :");
            username = Container.sc.nextLine().trim();

            if(username.isEmpty()) {
                System.out.println("id를 입력하세요");
                continue;
            }

            Member existUserId = memberService.findByUserName(username);

            if(existUserId != null) {
                System.out.println("중복된 id 입니다 다시 입력해주세요!");
                continue;
            }
            break;
        }

        while(true) {

            System.out.println("비밀번호 :");
            password = Container.sc.nextLine().trim();

            if(password.isEmpty()) {
                System.out.println("패스워드1을 입력하세요");
                continue;
            }

            System.out.println("비밀번호 확인 :");
            passwordConfirm = Container.sc.nextLine().trim();

            if(passwordConfirm.isEmpty()) {
                System.out.println("비밀번호 확인을  입력하세요");
                continue;
            }
            if(!password.equals(passwordConfirm)) {
                System.out.println("비밀번호가 일치 하지 않습니다.");
                continue;
            }
            break;
        }

        while(true) {

            System.out.println("이름 :");
            name = Container.sc.nextLine().trim();

            if(name.isEmpty()) {
                System.out.println("이름을 입력하세요");
                continue;
            }
            break;
        }


        Member member = memberService.join(username, password, name);
        String message = "%s 님 회원가입 되었습니다".formatted(member.getName());
        System.out.println(message);

    }
}
