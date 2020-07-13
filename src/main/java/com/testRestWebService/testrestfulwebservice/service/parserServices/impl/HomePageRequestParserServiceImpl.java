package com.testRestWebService.testrestfulwebservice.service.parserServices.impl;

import com.testRestWebService.testrestfulwebservice.domain.HomePage;
import com.testRestWebService.testrestfulwebservice.service.parserServices.HomePageRequestParserService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class HomePageRequestParserServiceImpl implements HomePageRequestParserService {


    public HomePageRequestParserServiceImpl() {
    }

    public HomePage parseHomeRequest(String request){
            String regexOfPattern = "(https://www.trendyol.com)((/)(.*)(/)(.*)(/)(.*))?";
            Pattern pattern = Pattern.compile(regexOfPattern);
            Matcher matcher = pattern.matcher(request);
            if (matcher.find( )) {
                return new HomePage(matcher.group(8),request);
            }
            return new HomePage(null,request);

        }
}
