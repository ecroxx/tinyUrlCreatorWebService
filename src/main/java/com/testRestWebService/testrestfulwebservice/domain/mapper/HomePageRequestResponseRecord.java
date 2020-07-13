package com.testRestWebService.testrestfulwebservice.domain.mapper;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class HomePageRequestResponseRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String request ;

    private Timestamp timestamp;

    private String response;


    public HomePageRequestResponseRecord() {
    }

    public HomePageRequestResponseRecord(String request, Timestamp timestamp, String response) {
        this.request = request;
        this.timestamp = timestamp;
        this.response = response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
