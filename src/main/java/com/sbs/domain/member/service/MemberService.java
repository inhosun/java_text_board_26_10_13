package com.sbs.domain.member.service;

import com.sbs.domain.article.global.base.container.Container;
import com.sbs.domain.member.member.dto.Member;
import com.sbs.domain.member.repository.MemberRepository;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = Container.memberRepository;
    }

    public Member join(String username, String password, String name) {
        return memberRepository.join(username, password, name);
    }

    public Member findByUserName(String username) {
        return memberRepository.findByUserName(username);
    }

    public Member findById(int id) {
        return memberRepository.findById(id);
    }

    public Member login(String username, String password) {
        return memberRepository.login(username, password);
    }
}
