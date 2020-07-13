package com.testRestWebService.testrestfulwebservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final static String Page;
    private String webURL;
    private String domain;
    private Integer mercantID;
    private Integer butiqueID;
    private String brandName;
    private String productName;
    private Integer contentID;

    static
    {
        Page="Product";
    }

    public ProductPage() {
    }

    public ProductPage(String webURL) {
        this.webURL = webURL;
    }


    public ProductPage(int mercantID, int butiqueID, String brandName, String productName, int contentID) {
        this.mercantID = mercantID;
        this.butiqueID = butiqueID;
        this.brandName = brandName;
        this.productName = productName;
        this.contentID = contentID;
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void parseWebUrl(){

    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getMercantID() {
        return mercantID;
    }

    public void setMercantID(Integer mercantID) {
        this.mercantID = mercantID;
    }

    public Integer getButiqueID() {
        return butiqueID;
    }

    public void setButiqueID(Integer butiqueID) {
        this.butiqueID = butiqueID;
    }

    public Integer getContentID() {
        return contentID;
    }

    public void setContentID(Integer contentID) {
        this.contentID = contentID;
    }
}
