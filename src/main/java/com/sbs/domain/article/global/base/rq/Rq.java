package com.sbs.domain.article.global.base.rq;

import com.sbs.domain.article.global.Session.Session;
import lombok.Getter;
import lombok.Setter;

public class Rq {
    @Getter
    @Setter
    public String url;

    @Getter
    @Setter
    public String urlPathUserType;

    @Getter
    @Setter
    public String urlPathControllerName;

    @Getter
    @Setter
    public String urlPathUserAction;

    @Getter
    @Setter
    public String urlPathVariable;

    public Session session;

    private String loginedMember = "loginedMember";

    public Rq() {
        session = new Session();
    }

    public void setCommand(String url) {
        this.url = url;
    }

    public String getActionPath() {
        String[] urlBits = url.trim().split("/");

            urlPathUserType = urlBits[1];
            urlPathControllerName = urlBits[2];
            urlPathUserAction = urlBits[3];
        return "/%s/%s/%s".formatted(urlPathUserType, urlPathControllerName,urlPathUserAction);
    }

    public int getPathVariable() {
        String[] urlBits = url.trim().split("/");

        int id = 0;

        try {
           id = Integer.parseInt(urlBits[4]) ;
           return id;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return id;
        }
    }

    public boolean isLogined() {
        return hasAttr(loginedMember);
    }

    public boolean isLogout() {
        return !hasAttr(loginedMember);
    }

    public void setAttr(String key, Object value) {
        session.setAttribute(key, value);
    }

    public Object getAttr(String key) {
        return session.getAttribute(key);
    }

    public void removeAttr(String key) {
        session.removeAttribute(key);
    }

    public boolean hasAttr(String key) {
        return session.hasAttribute(key);
    }
}
