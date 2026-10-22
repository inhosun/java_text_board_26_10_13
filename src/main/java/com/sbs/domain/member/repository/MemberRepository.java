package com.sbs.domain.member.repository;

import com.sbs.domain.member.member.dto.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberRepository {
    List<Member> members;

    public MemberRepository() {

        this.members = new ArrayList<>();

        makeTestData();
    }

    public Member join(String username, String password, String name) {
        Member member = new Member(username, password, name);
        members.add(member);
        return member;
    }

    public void makeTestData() {
        Member member1 = new Member("user1","1234","유저1");
        members.add(member1);
        Member member2 = new Member("user2","1234","유저2");
        members.add(member2);
        Member member3 = new Member("user3","1234","유저3");
        members.add(member3);

    }
    public Member findByUserName(String username) {
        return members.stream()
                .filter(member -> username.equals(member.getUsername()))
                .findFirst()
                .orElse(null);
    }

    public Member login(String username, String password) {
        return members.stream()
                .filter(member -> username.equals(member.getUsername()) && password.equals(member.getPassword()))
                .findFirst()
                .orElse(null);
    }

    public Member findById(int id) {
        return members.stream()
                .filter(member -> member.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
