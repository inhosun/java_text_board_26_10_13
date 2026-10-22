package com.sbs.domain.article.global.base.intercepter;

import com.sbs.domain.article.global.base.rq.Rq;

public class NeedLoginIntercepter implements Intercepter{
    @Override
    public boolean run(Rq rq) {
        System.out.println("======NeedLoginIntercepter 시작=======");
        if(rq.isLogined())
            return true;

        boolean result = true;


        switch(rq.getActionPath()) {
            case "/usr/article/write",
                 "/usr/article/modify",
                 "/usr/article/delete",
                 "/usr/member/logout",
                 "/usr/member/my-page" -> {
                System.out.println("로그인후 이용하시기 바랍니다!");
                result = false;
            }
        }
        System.out.println("======NeedLoginIntercepter 끝=======");
        return result;
    }
}
