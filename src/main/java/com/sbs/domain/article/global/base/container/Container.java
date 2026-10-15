package com.sbs.domain.article.global.base.container;

import com.sbs.domain.article.controller.ArticleController;
import com.sbs.domain.article.global.base.rq.Rq;
import com.sbs.domain.article.repository.ArticleRepository;
import com.sbs.domain.article.service.ArticleService;

import java.util.Scanner;

public class Container {

    public static Scanner sc;
    public static ArticleRepository articleRepository;
    public static ArticleService articleService;
    public static ArticleController articleController;
    public static Rq rq;

    static {
        sc = new Scanner(System.in);
        articleRepository = new ArticleRepository();
        articleService = new ArticleService();
        articleController = new ArticleController();
        rq = new Rq();
    }
}
