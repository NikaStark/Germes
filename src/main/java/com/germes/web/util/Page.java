package com.germes.web.util;

public enum Page {

    HOME_PAGE("/WEB-INF/pages/home.jsp");

    private String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
