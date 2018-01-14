package com.germes.web.util;

public enum Page {

    DEFAULT_PAGE("/WEB-INF/pages/index.jsp"),
    HOME_PAGE("/WEB-INF/pages/home.jsp"),
    LOGIN_PAGE("/WEB-INF/pages/login.jsp"),
    REG_PAGE("/WEB-INF/pages/registration.jsp");

    private String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
