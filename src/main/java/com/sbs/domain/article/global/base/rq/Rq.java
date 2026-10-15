package com.sbs.domain.article.global.base.rq;

import lombok.Getter;
import lombok.Setter;

public class Rq {
    @Getter
    @Setter
    String url;

    @Getter
    @Setter
    String urlPathUserType;

    @Getter
    @Setter
    String urlPathControllerName;

    @Getter
    @Setter
    String urlPathUserAction;

    @Getter
    @Setter
    String urlPathVariable;

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
}
