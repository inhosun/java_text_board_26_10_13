package com.sbs.domain.article.global.base.container;

import com.sbs.domain.article.controller.ArticleController;
import com.sbs.domain.article.global.Session.Session;
import com.sbs.domain.article.global.base.intercepter.NeedLogOutIntercepter;
import com.sbs.domain.article.global.base.intercepter.NeedLoginIntercepter;
import com.sbs.domain.article.global.base.rq.Rq;
import com.sbs.domain.article.repository.ArticleRepository;
import com.sbs.domain.article.service.ArticleService;
import com.sbs.domain.member.controller.MemberController;
import com.sbs.domain.member.repository.MemberRepository;
import com.sbs.domain.member.service.MemberService;

import java.util.Scanner;

public class Container {

    public static Scanner sc;
    public static ArticleRepository articleRepository;
    public static ArticleService articleService;
    public static ArticleController articleController;
    public static MemberController memberController;
    public static MemberService memberService;
    public static MemberRepository memberRepository;
    public static Session session;
    public static NeedLoginIntercepter needLoginIntercepter;
    public static NeedLogOutIntercepter needLogOutIntercepter;
    public static Rq rq;

    static {
        sc = new Scanner(System.in);
        articleRepository = new ArticleRepository();
        articleService = new ArticleService();
        articleController = new ArticleController();
        memberRepository = new MemberRepository();
        memberService = new MemberService();
        memberController = new MemberController();
        needLoginIntercepter = new NeedLoginIntercepter();
        needLogOutIntercepter = new NeedLogOutIntercepter();
        session = new Session();

        rq = new Rq();
    }
}
