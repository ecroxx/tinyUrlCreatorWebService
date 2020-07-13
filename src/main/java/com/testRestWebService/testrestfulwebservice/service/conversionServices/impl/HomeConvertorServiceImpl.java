package com.testRestWebService.testrestfulwebservice.service.conversionServices.impl;

import com.testRestWebService.testrestfulwebservice.domain.HomePage;
import com.testRestWebService.testrestfulwebservice.service.conversionServices.HomeConvertorService;
import org.springframework.stereotype.Service;

@Service
public class HomeConvertorServiceImpl implements HomeConvertorService {
    public HomeConvertorServiceImpl() {
    }

    @Override
    public String homePageConvert(HomePage homePage) {
        StringBuilder builder=new StringBuilder();
        builder.append("ty://?Page=").append(HomePage.getPage());
        if(homePage.getSectionName()!=null){builder.append("&SectionId="+HomePage.getSectionNameMap().get(homePage.getSectionName()));}
        return builder.toString();
    }
}
