package com.sbs.domain.member.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Member {

    private static int lastId;
    private int id;

    private String username;

    private String password;

    private String name;

    static {
        lastId = 0;
    }

    public Member(String username, String password, String name) {
        this(++lastId, username, password, name);
    }

    public Member(int id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }


    @Override
    public String toString() {
        // return "{id : %d , title : %s , content : %s}".formatted(id, title, content);
        return String.format("{id : %d , title : %s , content : %s}", id, username, password, name);
    }

}
