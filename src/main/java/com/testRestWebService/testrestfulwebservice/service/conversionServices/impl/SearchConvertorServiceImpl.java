package com.testRestWebService.testrestfulwebservice.service.conversionServices.impl;

import com.testRestWebService.testrestfulwebservice.domain.SearchPage;
import com.testRestWebService.testrestfulwebservice.service.conversionServices.SearchConvertorService;
import org.springframework.stereotype.Service;

@Service
public class SearchConvertorServiceImpl implements SearchConvertorService {
    public SearchConvertorServiceImpl() {
    }

    @Override
    public String searchPageConvert(SearchPage searchPage) {
        StringBuilder builder=new StringBuilder();
        builder.append("ty://?Page=").append(SearchPage.getPage());
        if(searchPage.getQuery()!=null){builder.append("&Query="+searchPage.getQuery());}
        return builder.toString();
    }
}
