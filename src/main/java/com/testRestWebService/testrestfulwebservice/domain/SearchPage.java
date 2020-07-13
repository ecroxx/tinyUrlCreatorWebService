package com.testRestWebService.testrestfulwebservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SearchPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final static String Page;
    private String query;
    private String webURL;
    static
    {
        Page="Search";
    }

    public SearchPage() {
    }

    public SearchPage(String query) {
        this.query = query;
    }

    public SearchPage(String query, String webURL) {
        this.query = query;
        this.webURL = webURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public static String getPage() {
        return Page;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }
}
