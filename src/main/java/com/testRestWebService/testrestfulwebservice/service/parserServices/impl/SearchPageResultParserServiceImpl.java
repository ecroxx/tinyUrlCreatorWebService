package com.testRestWebService.testrestfulwebservice.service.parserServices.impl;

import com.testRestWebService.testrestfulwebservice.domain.SearchPage;
import com.testRestWebService.testrestfulwebservice.service.parserServices.SearchPageRequestParserService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class SearchPageResultParserServiceImpl implements SearchPageRequestParserService {


    public SearchPage parseSearchRequest(String request){

        String patternXSearch = "(https://www.trendyol.com)(/tum-urunler)(.)(q=)(.*)";
        Pattern pattern = Pattern.compile(patternXSearch);
        Matcher matcher = pattern.matcher(request);
        if (matcher.find( )) {
            return new SearchPage(matcher.group(5),request);
        }
        return new SearchPage(null,request);



    }


}
