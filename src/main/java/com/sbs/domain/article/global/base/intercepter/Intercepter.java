package com.sbs.domain.article.global.base.intercepter;

import com.sbs.domain.article.global.base.rq.Rq;

public interface Intercepter {
    public boolean run(Rq rq);
}
