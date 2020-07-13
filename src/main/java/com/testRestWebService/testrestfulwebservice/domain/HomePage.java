package com.testRestWebService.testrestfulwebservice.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class HomePage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static final String Page;
    private static final Map<String,Integer> SectionNameMap;

    private String sectionName;

    private String webURL;

    public HomePage() {
    }


    static {
        Page="Home";
        SectionNameMap=new HashMap();
        SectionNameMap.put("kadin",1);
        SectionNameMap.put("erkek",2);
        SectionNameMap.put("supermarket",3);
        SectionNameMap.put("cocuk",4);
    }

    public HomePage(String sectionName) {
        this.sectionName = sectionName;
    }

    public HomePage(String sectionName, String webURL) {
        this.sectionName = sectionName;
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

    public static Map<String, Integer> getSectionNameMap() {
        return SectionNameMap;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }


}
