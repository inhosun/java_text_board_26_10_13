package com.sbs.domain.article.global.base.intercepter;

import com.sbs.domain.article.global.base.rq.Rq;

public class NeedLogOutIntercepter implements Intercepter{
    @Override
    public boolean run(Rq rq) {
        System.out.println("======NeedLogOutIntercepter 시작=======");
        if(rq.isLogout()) {
            return true;
        }
        boolean result;
        switch(rq.getActionPath()) {
            case "/usr/member/write",
                 "/usr/member/join" -> {
                System.out.println("로그아웃 후 사용해 주세요");
                result = false;
            }
            default -> result=true;
        }
        System.out.println("======NeedLogOutIntercepter 끝=======");
        return result;
    }
}
